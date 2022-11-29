package sogang.capstone.editking.domain.user;

import java.util.Optional;

public interface UserRepository {

    public Optional<User> findByIdOptional(Long id);

    public User findById(Long id);

    public Optional<User> findByAuthenticationCode(String authenticationCode);

    public void save(User user);
}
