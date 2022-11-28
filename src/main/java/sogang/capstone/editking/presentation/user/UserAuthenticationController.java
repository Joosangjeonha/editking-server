package sogang.capstone.editking.presentation.user;

import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.common.response.CommonResponse;
import sogang.capstone.editking.domain.user.JwtTokenService;
import sogang.capstone.editking.domain.user.KakaoService;
import sogang.capstone.editking.domain.user.NaverService;
import sogang.capstone.editking.domain.user.UserAuthenticationService;
import sogang.capstone.editking.presentation.user.dto.TokenDTO;
import sogang.capstone.editking.presentation.user.dto.UserIdDTO;
import sogang.capstone.editking.presentation.user.dto.oauth.KakaoTokenDTO;
import sogang.capstone.editking.presentation.user.dto.oauth.KakaoUserDTO;
import sogang.capstone.editking.presentation.user.dto.oauth.NaverTokenDTO;
import sogang.capstone.editking.presentation.user.dto.oauth.NaverUserDTO;
import sogang.capstone.editking.presentation.user.dto.oauth.UserInfoDTO;
import sogang.capstone.editking.presentation.user.request.KakaoRequest;
import sogang.capstone.editking.presentation.user.request.NaverRequest;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAuthenticationController {

    private final KakaoService kakaoService;
    private final NaverService naverService;
    private final UserAuthenticationService userAuthenticationService;
    private final JwtTokenService jwtTokenService;

    @Operation(summary = "카카오 로그인")
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

    @Operation(summary = "네이버 로그인")
    @PostMapping(value = "/naver", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<TokenDTO> loginWithNaver(@Valid @RequestBody NaverRequest naverRequest) {

        NaverTokenDTO naverTokenDTO = naverService.getNaverAccessToken(naverRequest);
        NaverUserDTO naverUserDTO = naverService.getNaverUserCode(naverTokenDTO);

        UserIdDTO userIdDTO = userAuthenticationService.loginWithUserInformation(
                new UserInfoDTO(naverUserDTO, "naver"));

        String refreshToken = jwtTokenService.encodeJwtRefreshToken(userIdDTO);
        String accessToken = jwtTokenService.encodeJwtToken(userIdDTO);

        userAuthenticationService.updateRefreshToken(userIdDTO, refreshToken);

        return CommonResponse.onSuccess(new TokenDTO(accessToken));
    }
}