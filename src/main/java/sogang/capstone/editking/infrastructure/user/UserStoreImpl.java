package sogang.capstone.editking.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.domain.user.UserStore;

@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {

    private final UserRepository userRepository;

    @Override
    public User store(User user) {
        return userRepository.save(user);
    }

}
