package sogang.capstone.editking.domain.user.auth;

import sogang.capstone.editking.domain.user.UserCommand.KakaoRequest;
import sogang.capstone.editking.domain.user.UserInfo.Login;


public interface KakaoService {

    public KakaoInfo.Token getKakaoAccessToken(KakaoRequest kakaoRequest);

    public Login getKakaoUserCode(KakaoInfo.Token kakaoToken);
    
}
