package sogang.capstone.editking.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import sogang.capstone.editking.common.exception.BadRequestException;

@Service
@RequiredArgsConstructor
public class KakaoService {

    private final WebClient webClient;
    private final UserInfoMapper userInfoMapper;

    @Value("${kakao.key}")
    private String KAKAO_KEY;
    @Value("${kakao.uri}")
    private String KAKAO_URI;

    public KakaoInfo.Token getKakaoAccessToken(UserCommand.KakaoRequest kakaoRequest) {
        String getTokenURL =
                "https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id="
                        + KAKAO_KEY + "&redirect_uri=" + KAKAO_URI + "&code="
                        + kakaoRequest.getCode();

        WebClient.ResponseSpec responseSpec = webClient.post().uri(getTokenURL).retrieve();

        try {
            KakaoInfo.Token kakaoToken = responseSpec.bodyToMono(KakaoInfo.Token.class).block();
            return kakaoToken;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("kakao access token error");
        }
    }

    public UserInfo.Login getKakaoUserCode(KakaoInfo.Token kakaoToken) {
        String getUserURL = "https://kapi.kakao.com/v2/user/me";

        WebClient.ResponseSpec responseSpec = webClient.post().uri(getUserURL)
                .header("Authorization", "Bearer " + kakaoToken.getAccessToken()).retrieve();

        try {
            KakaoInfo.User kakaoUser = responseSpec.bodyToMono(KakaoInfo.User.class).block();
            return userInfoMapper.of(kakaoUser);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("kakao user code error");
        }
    }
}
