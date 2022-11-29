package sogang.capstone.editking.domain.user.auth;

import sogang.capstone.editking.domain.user.UserCommand.NaverRequest;
import sogang.capstone.editking.domain.user.UserInfo.Login;


public interface NaverService {

    public NaverInfo.Token getNaverAccessToken(NaverRequest naverRequest);

    public Login getNaverUserCode(NaverInfo.Token naverToken);
    
}
