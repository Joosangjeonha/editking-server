package sogang.capstone.editking.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import sogang.capstone.editking.common.exception.BadRequestException;
import sogang.capstone.editking.presentation.user.dto.oauth.NaverTokenDTO;
import sogang.capstone.editking.presentation.user.dto.oauth.NaverUserDTO;
import sogang.capstone.editking.presentation.user.request.NaverRequest;

@Service
@RequiredArgsConstructor
public class NaverService {

    private final WebClient webClient;

    @Value("${naver.key}")
    private String NAVER_KEY;
    @Value("${naver.secret}")
    private String NAVER_SECRET;
    @Value("${naver.uri}")
    private String NAVER_URI;

    public NaverTokenDTO getNaverAccessToken(NaverRequest naverRequest) {

        String getTokenURL =
                "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id="
                        + NAVER_KEY + "&client_secret=" + NAVER_SECRET + "&redirect_uri=" + NAVER_URI
                        + "&code=" + naverRequest.getCode() + "&state=" + naverRequest.getState();

        WebClient.ResponseSpec responseSpec = webClient.post().uri(getTokenURL).retrieve();

        try {
            NaverTokenDTO naverTokenDTO = responseSpec.bodyToMono(NaverTokenDTO.class).block();
            return naverTokenDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("naver access token error");
        }
    }

    public NaverUserDTO getNaverUserCode(NaverTokenDTO naverTokenDTO) {
        String getUserURL = "https://openapi.naver.com/v1/nid/me";

        WebClient.ResponseSpec responseSpec = webClient.post().uri(getUserURL)
                .header("Authorization", "Bearer " + naverTokenDTO.getAccessToken()).retrieve();

        try {
            NaverUserDTO naverUserDTO = responseSpec.bodyToMono(NaverUserDTO.class).block();
            return naverUserDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("naver user code error");
        }
    }
}
