package mk.ukim.finki.users.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.users.domain.models.User;
import mk.ukim.finki.users.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final UserRepository userRepository;
    @PostConstruct
    public void initData() {
        User u1 = User.create("Atanas", "Atanasov","malle2002");
        User u2 = User.create("Mite", "Mitkov","m.m2002itkov");
        if (userRepository.findAll().isEmpty()) {
            userRepository.saveAll(Arrays.asList(u1,u2));
        }
    }

}
