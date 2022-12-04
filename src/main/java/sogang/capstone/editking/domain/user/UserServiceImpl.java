package sogang.capstone.editking.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserReader userReader;

    @Override
    @Transactional
    public void userLogout(User user) {
        User logoutUser = userReader.getUser(user.getId());
        logoutUser.setNewRefreshToken("");
    }


}
