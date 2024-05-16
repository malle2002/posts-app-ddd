package mk.ukim.finki.users.xport;

import lombok.AllArgsConstructor;
import mk.ukim.finki.users.domain.models.User;
import mk.ukim.finki.users.domain.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserResource {
    private final UserRepository userRepository;
    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
