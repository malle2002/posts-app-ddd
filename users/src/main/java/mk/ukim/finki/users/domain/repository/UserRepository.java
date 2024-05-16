package mk.ukim.finki.users.domain.repository;

import mk.ukim.finki.users.domain.models.User;
import mk.ukim.finki.users.domain.models.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UserId> {
}
