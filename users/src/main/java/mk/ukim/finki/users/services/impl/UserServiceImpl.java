package mk.ukim.finki.users.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.users.domain.exceptions.UserIdNotExistsException;
import mk.ukim.finki.users.domain.models.User;
import mk.ukim.finki.users.domain.models.UserId;
import mk.ukim.finki.users.domain.repository.UserRepository;
import mk.ukim.finki.users.services.UserService;
import mk.ukim.finki.users.services.form.UserForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(UserId id) {
        return userRepository.findById(id).orElseThrow(UserIdNotExistsException::new);
    }

    @Override
    public User createUser(UserForm userForm) {
        User p = User.create(userForm.getName(),userForm.getSurname(),userForm.getUsername());
        userRepository.save(p);
        return p;

    }
}
