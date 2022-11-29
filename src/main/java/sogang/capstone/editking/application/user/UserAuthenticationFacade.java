package sogang.capstone.editking.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.domain.user.UserAuthenticationService;
import sogang.capstone.editking.domain.user.UserCommand;
import sogang.capstone.editking.domain.user.UserInfo;
import sogang.capstone.editking.domain.user.auth.JwtTokenService;
import sogang.capstone.editking.domain.user.auth.KakaoInfo;
import sogang.capstone.editking.domain.user.auth.KakaoService;
import sogang.capstone.editking.domain.user.auth.NaverInfo;
import sogang.capstone.editking.domain.user.auth.NaverService;

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

    public UserInfo.Token loginWithNaver(UserCommand.NaverRequest request) {

        NaverInfo.Token naverToken = naverService.getNaverAccessToken(request);
        UserInfo.Login naverUser = naverService.getNaverUserCode(naverToken);

        UserInfo.Id userId = userAuthenticationService.loginWithUserInformation(naverUser, "naver");

        String refreshToken = jwtTokenService.encodeJwtRefreshToken(userId);
        UserInfo.Token accessToken = jwtTokenService.encodeJwtToken(userId);

        userAuthenticationService.updateRefreshToken(userId, refreshToken);

        return accessToken;
    }
}
