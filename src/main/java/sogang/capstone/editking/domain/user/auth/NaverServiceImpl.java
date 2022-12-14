package sogang.capstone.editking.domain.user.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import sogang.capstone.editking.common.exception.BadRequestException;
import sogang.capstone.editking.domain.user.UserCommand.NaverRequest;
import sogang.capstone.editking.domain.user.UserInfo.Login;
import sogang.capstone.editking.domain.user.UserInfoMapper;

@Service
@RequiredArgsConstructor
public class NaverServiceImpl implements NaverService {

    private final WebClient webClient;
    private final UserInfoMapper userInfoMapper;

    @Value("${naver.key}")
    private String NAVER_KEY;
    @Value("${naver.secret}")
    private String NAVER_SECRET;
    @Value("${naver.uri}")
    private String NAVER_URI;

    @Override
    public NaverInfo.Token getNaverAccessToken(NaverRequest naverRequest) {

        String getTokenURL =
                "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id="
                        + NAVER_KEY + "&client_secret=" + NAVER_SECRET + "&redirect_uri=" + NAVER_URI
                        + "&code=" + naverRequest.getCode() + "&state=" + naverRequest.getState();

        WebClient.ResponseSpec responseSpec = webClient.post().uri(getTokenURL).retrieve();

        try {
            NaverInfo.Token naverTokenDTO = responseSpec.bodyToMono(NaverInfo.Token.class).block();
            return naverTokenDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("naver access token error");
        }
    }

    @Override
    public Login getNaverUserCode(NaverInfo.Token naverToken) {
        String getUserURL = "https://openapi.naver.com/v1/nid/me";

        WebClient.ResponseSpec responseSpec = webClient.post().uri(getUserURL)
                .header("Authorization", "Bearer " + naverToken.getAccessToken()).retrieve();

        try {
            NaverInfo.User naverUser = responseSpec.bodyToMono(NaverInfo.User.class).block();
            return userInfoMapper.of(naverUser);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("naver user code error");
        }
    }

}
