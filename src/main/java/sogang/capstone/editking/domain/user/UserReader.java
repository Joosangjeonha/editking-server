package sogang.capstone.editking.domain.user;

import java.util.Optional;

public interface UserReader {

    User getUser(Long id);

    Optional<User> findById(Long id);

    Optional<User> findByAuthenticationCode(String authenticationCode);
}
