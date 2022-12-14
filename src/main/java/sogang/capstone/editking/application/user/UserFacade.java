package sogang.capstone.editking.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.domain.user.UserCommand;
import sogang.capstone.editking.domain.user.UserInfo;
import sogang.capstone.editking.domain.user.UserService;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    public void logout(User user) {
        userService.userLogout(user);
    }

    public UserInfo.Main editUserAccount(User user, UserCommand.EditAccountRequest request) {
        return userService.editUserAccount(user, request);
    }

}
