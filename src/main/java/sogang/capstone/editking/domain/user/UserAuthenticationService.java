package sogang.capstone.editking.domain.user;

public interface UserAuthenticationService {

    public UserInfo.Id loginWithUserInformation(UserInfo.Login userInfo, String provider);

    public void updateRefreshToken(UserInfo.Id userId, String refreshToken);

    public void validateLatestDevice(String refreshToken);
}
