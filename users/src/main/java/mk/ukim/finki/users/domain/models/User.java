package mk.ukim.finki.users.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name="app_users")
@Getter
public class User extends AbstractEntity<UserId> {
    private String name;
    private String surname;
    private String username;
    private User() {
        super(UserId.randomId(UserId.class));
    }
    public static User create(String name, String surname, String username) {
        User p = new User();
        p.name = name;
        p.surname = surname;
        p.username = username;
        return p;
    }

}
