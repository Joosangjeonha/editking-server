package sogang.capstone.editking.user.presentation;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.global.config.CommonResponse;
import sogang.capstone.editking.user.application.JwtTokenService;
import sogang.capstone.editking.user.application.KakaoService;
import sogang.capstone.editking.user.application.UserAuthenticationService;
import sogang.capstone.editking.user.application.dto.TokenDTO;
import sogang.capstone.editking.user.application.dto.UserIdDTO;
import sogang.capstone.editking.user.application.dto.oauth.KakaoTokenDTO;
import sogang.capstone.editking.user.application.dto.oauth.KakaoUserDTO;
import sogang.capstone.editking.user.application.dto.oauth.UserInfoDTO;
import sogang.capstone.editking.user.application.request.KakaoRequest;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAuthenticationController {

    private final KakaoService kakaoService;
    private final UserAuthenticationService userAuthenticationService;
    private final JwtTokenService jwtTokenService;

    @PostMapping(value = "/kakao", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<TokenDTO> loginWithKakao(@Valid @RequestBody KakaoRequest kakaoRequest) {

        KakaoTokenDTO kakaoTokenDTO = kakaoService.getKakaoAccessToken(kakaoRequest);
        KakaoUserDTO kakaoUserDTO = kakaoService.getKakaoUserCode(kakaoTokenDTO);

        UserIdDTO userIdDTO = userAuthenticationService.loginWithUserInformation(
            new UserInfoDTO(kakaoUserDTO, "kakao"));

        String refreshToken = jwtTokenService.encodeJwtRefreshToken(userIdDTO);
        String accessToken = jwtTokenService.encodeJwtToken(userIdDTO);

        userAuthenticationService.updateRefreshToken(userIdDTO, refreshToken);

        return CommonResponse.onSuccess(new TokenDTO(accessToken));
    }
}
