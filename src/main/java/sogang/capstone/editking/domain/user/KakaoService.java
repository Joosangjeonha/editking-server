package sogang.capstone.editking.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import sogang.capstone.editking.common.exception.BadRequestException;
import sogang.capstone.editking.presentation.user.dto.oauth.KakaoTokenDTO;
import sogang.capstone.editking.presentation.user.dto.oauth.KakaoUserDTO;
import sogang.capstone.editking.presentation.user.request.KakaoRequest;

@Service
@RequiredArgsConstructor
public class KakaoService {

    private final WebClient webClient;

    @Value("${kakao.key}")
    private String KAKAO_KEY;
    @Value("${kakao.uri}")
    private String KAKAO_URI;

    public KakaoTokenDTO getKakaoAccessToken(KakaoRequest kakaoRequest) {
        String getTokenURL =
                "https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id="
                        + KAKAO_KEY + "&redirect_uri=" + KAKAO_URI + "&code="
                        + kakaoRequest.getCode();

        WebClient.ResponseSpec responseSpec = webClient.post().uri(getTokenURL).retrieve();

        try {
            KakaoTokenDTO kakaoTokenDTO = responseSpec.bodyToMono(KakaoTokenDTO.class).block();
            return kakaoTokenDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("kakao access token error");
        }
    }

    public KakaoUserDTO getKakaoUserCode(KakaoTokenDTO kakaoTokenDTO) {
        String getUserURL = "https://kapi.kakao.com/v2/user/me";

        WebClient.ResponseSpec responseSpec = webClient.post().uri(getUserURL)
                .header("Authorization", "Bearer " + kakaoTokenDTO.getAccessToken()).retrieve();

        try {
            KakaoUserDTO kakaoUserDTO = responseSpec.bodyToMono(KakaoUserDTO.class).block();
            return kakaoUserDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("kakao user code error");
        }
    }
}
