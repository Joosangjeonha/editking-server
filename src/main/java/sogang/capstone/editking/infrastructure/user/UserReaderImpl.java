package sogang.capstone.editking.infrastructure.user;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.common.exception.EntityNotFoundException;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.domain.user.UserReader;

@Component
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

    private final UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByAuthenticationCode(String authenticationCode) {
        return userRepository.findByAuthenticationCode(authenticationCode);
    }

    @Override
    public User findByRefreshToken(String refreshToken) {
        return userRepository.findByRefreshToken(refreshToken)
                .orElseThrow(EntityNotFoundException::new);
    }
}
