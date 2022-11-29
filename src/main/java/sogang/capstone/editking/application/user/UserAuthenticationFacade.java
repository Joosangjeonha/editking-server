package sogang.capstone.editking.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.domain.user.JwtTokenService;
import sogang.capstone.editking.domain.user.KakaoInfo;
import sogang.capstone.editking.domain.user.KakaoService;
import sogang.capstone.editking.domain.user.NaverService;
import sogang.capstone.editking.domain.user.UserAuthenticationService;
import sogang.capstone.editking.domain.user.UserCommand;
import sogang.capstone.editking.domain.user.UserInfo;

@Service
@RequiredArgsConstructor
public class UserAuthenticationFacade {

    private final KakaoService kakaoService;
    private final NaverService naverService;
    private final UserAuthenticationService userAuthenticationService;
    private final JwtTokenService jwtTokenService;

    public UserInfo.Token loginWithKakao(UserCommand.KakaoRequest request) {
        KakaoInfo.Token kakaoToken = kakaoService.getKakaoAccessToken(request);
        UserInfo.Login kakaoUser = kakaoService.getKakaoUserCode(kakaoToken);

        UserInfo.Id userId = userAuthenticationService.loginWithUserInformation(kakaoUser, "kakao");

        String refreshToken = jwtTokenService.encodeJwtRefreshToken(userId);
        UserInfo.Token accessToken = jwtTokenService.encodeJwtToken(userId);

        userAuthenticationService.updateRefreshToken(userId, refreshToken);

        return accessToken;
    }
}
