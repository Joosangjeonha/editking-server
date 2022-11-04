package sogang.capstone.editking.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogang.capstone.editking.user.domain.User;
import sogang.capstone.editking.user.domain.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public void userLogout(User user) {
        user.setNewRefreshToken("");
    }

}
