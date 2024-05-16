package mk.ukim.finki.users.services;

import mk.ukim.finki.users.domain.models.User;
import mk.ukim.finki.users.domain.models.UserId;
import mk.ukim.finki.users.services.form.UserForm;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(UserId id);
    User createUser(UserForm userForm);
}
