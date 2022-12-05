package sogang.capstone.editking.domain.user;

public interface UserService {

    public void userLogout(User user);

    public UserInfo.Main editUserAccount(User user, UserCommand.EditAccountRequest request);
}
