package sogang.capstone.editking.domain.user;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    private final UserReader userReader;
    private final UserStore userStore;
    private final UserInfoMapper userInfoMapper;

    @Override
    @Transactional
    public UserInfo.Id loginWithUserInformation(UserInfo.Login userInfo, String provider) {
        Optional<User> registeredUser = userReader.findByAuthenticationCode(userInfo.getAuthenticationCode());

        UserInfo.Id userId;
        if (registeredUser.isPresent()) {
            userId = userInfoMapper.of(registeredUser.get());
        } else {
            User newUser = User.builder()
                    .name(userInfo.getName())
                    .authenticationCode(userInfo.getAuthenticationCode())
                    .provider(provider)
                    .refreshToken("")
                    .build();
            userStore.store(newUser);

            userId = userInfoMapper.of(newUser);
        }

        return userId;
    }

    @Override
    @Transactional
    public void updateRefreshToken(UserInfo.Id userId, String refreshToken) {
        User user = userReader.getUser(userId.getId());
        user.setNewRefreshToken(refreshToken);
    }

    @Override
    @Transactional(readOnly = true)
    public void validateLatestDevice(String refreshToken) {
        userReader.findByRefreshToken(refreshToken);
    }
}
