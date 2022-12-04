package sogang.capstone.editking.presentation.user;

import io.swagger.v3.oas.annotations.Operation;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.application.user.UserAuthenticationFacade;
import sogang.capstone.editking.common.response.CommonResponse;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAuthenticationController {

    private final UserAuthenticationFacade userAuthenticationFacade;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Operation(summary = "카카오 로그인")
    @PostMapping(value = "/kakao", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse loginWithKakao(@Valid @RequestBody UserRequest.KakaoRequest kakaoRequest,
            HttpServletResponse httpServletResponse) {

        var userCommand = userRequestMapper.of(kakaoRequest);
        var userResult = userAuthenticationFacade.loginWithKakao(userCommand);
        var response = userResponseMapper.of(userResult);

        Cookie cookie = new Cookie("refreshToken", userResult.getRefreshToken());
        cookie.setMaxAge(14 * 24 * 60 * 60);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);

        return CommonResponse.onSuccess(response);
    }

    @Operation(summary = "네이버 로그인")
    @PostMapping(value = "/naver", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse loginWithNaver(@Valid @RequestBody UserRequest.NaverRequest naverRequest,
            HttpServletResponse httpServletResponse) {

        var userCommand = userRequestMapper.of(naverRequest);
        var userResult = userAuthenticationFacade.loginWithNaver(userCommand);
        var response = userResponseMapper.of(userResult);

        Cookie cookie = new Cookie("refreshToken", userResult.getRefreshToken());
        cookie.setMaxAge(14 * 24 * 60 * 60);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);

        return CommonResponse.onSuccess(response);
    }

    @Operation(summary = "토큰 리프레시")
    @PostMapping(value = "/refresh", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse refreshTokens(@Valid @CookieValue("refreshToken") String refreshToken,
            HttpServletResponse httpServletResponse) {

        var userResult = userAuthenticationFacade.refreshTokens(refreshToken);
        var response = userResponseMapper.of(userResult);

        Cookie cookie = new Cookie("refreshToken", userResult.getRefreshToken());
        cookie.setMaxAge(14 * 24 * 60 * 60);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);

        return CommonResponse.onSuccess(response);
    }
}
