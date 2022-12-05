package sogang.capstone.editking.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserReader userReader;
    private final UserInfoMapper userInfoMapper;

    @Override
    @Transactional
    public void userLogout(User user) {
        User logoutUser = userReader.getUser(user.getId());
        logoutUser.setNewRefreshToken("");
    }

    @Override
    @Transactional
    public UserInfo.Main editUserAccount(User user, UserCommand.EditAccountRequest request) {
        User editUser = userReader.getUser(user.getId());
        editUser.editAccount(request);
        return userInfoMapper.of(editUser);
    }
}
