package sogang.capstone.editking.infrastructure.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sogang.capstone.editking.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByAuthenticationCode(String authenticationCode);

    public Optional<User> findByRefreshToken(String refreshToken);
}
