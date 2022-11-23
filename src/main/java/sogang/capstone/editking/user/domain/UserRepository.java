package sogang.capstone.editking.user.domain;

import java.util.Optional;

public interface UserRepository {

    public Optional<User> findByIdOptional(Long id);

    public User findById(Long id);

    public Optional<User> findByAuthenticationCode(String authenticationCode);

    public void save(User user);
}
