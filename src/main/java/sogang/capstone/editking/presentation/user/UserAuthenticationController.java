package sogang.capstone.editking.presentation.user;

import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.application.user.UserAuthenticationFacade;
import sogang.capstone.editking.common.response.CommonResponse;
import sogang.capstone.editking.domain.user.JwtTokenService;
import sogang.capstone.editking.domain.user.NaverService;
import sogang.capstone.editking.domain.user.UserAuthenticationService;
import sogang.capstone.editking.domain.user.UserInfo;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAuthenticationController {

    private final UserAuthenticationFacade userAuthenticationFacade;
    private final UserRequestMapper userRequestMapper;

    private final NaverService naverService;
    private final UserAuthenticationService userAuthenticationService;
    private final JwtTokenService jwtTokenService;

    @Operation(summary = "카카오 로그인")
    @PostMapping(value = "/kakao", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse loginWithKakao(@Valid @RequestBody UserRequest.KakaoRequest kakaoRequest) {

        var userCommand = userRequestMapper.of(kakaoRequest);
        UserInfo.Token response = userAuthenticationFacade.loginWithKakao(userCommand);

        return CommonResponse.onSuccess(response);
    }

//    @Operation(summary = "네이버 로그인")
//    @PostMapping(value = "/naver", produces = "application/json; charset=utf-8")
//    @ResponseBody
//    public CommonResponse<TokenDTO> loginWithNaver(@Valid @RequestBody NaverRequest naverRequest) {
//
//        NaverTokenDTO naverTokenDTO = naverService.getNaverAccessToken(naverRequest);
//        NaverUserDTO naverUserDTO = naverService.getNaverUserCode(naverTokenDTO);
//
//        UserIdDTO userIdDTO = userAuthenticationService.loginWithUserInformation(
//                new UserInfoDTO(naverUserDTO, "naver"));
//
//        String refreshToken = jwtTokenService.encodeJwtRefreshToken(userIdDTO);
//        String accessToken = jwtTokenService.encodeJwtToken(userIdDTO);
//
//        userAuthenticationService.updateRefreshToken(userIdDTO, refreshToken);
//
//        return CommonResponse.onSuccess(new TokenDTO(accessToken));
//    }
}
