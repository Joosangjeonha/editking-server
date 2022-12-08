package sogang.capstone.editking.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserInfoMapper userInfoMapper;
    private final UserStore userStore;

    @Override
    @Transactional
    public void userLogout(User user) {
        user.setNewRefreshToken("");
        userStore.store(user);
    }

    @Override
    @Transactional
    public UserInfo.Main editUserAccount(User user, UserCommand.EditAccountRequest request) {
        user.editAccount(request);
        userStore.store(user);
        return userInfoMapper.of(user);
    }
}
