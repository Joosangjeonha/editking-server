package sogang.capstone.editking.presentation.user;

import static sogang.capstone.editking.common.config.RedisConfig.USER_KEY;

import io.swagger.v3.oas.annotations.Operation;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.application.user.UserFacade;
import sogang.capstone.editking.common.response.CommonResponse;
import sogang.capstone.editking.domain.user.User;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Operation(summary = "로그아웃")
    @PatchMapping(value = "/logout", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse logout(@AuthenticationPrincipal User user,
            HttpServletResponse httpServletResponse) {

        userFacade.logout(user);

        Cookie cookie = new Cookie("refreshToken", null);
        cookie.setMaxAge(0);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);

        return CommonResponse.onSuccess(null);
    }

    @Operation(summary = "유저 정보")
    @Cacheable(value = USER_KEY, key = "#user.getId()", cacheManager = "cacheManager")
    @GetMapping(value = "", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse getUserAccount(@AuthenticationPrincipal User user) {

        var response = userResponseMapper.of(user);

        return CommonResponse.onSuccess(response);
    }

    @Operation(summary = "유저 정보 수정")
    @PatchMapping(value = "", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse editUserAccount(@AuthenticationPrincipal User user,
            @Valid @RequestBody UserRequest.EditAccountRequest request) {

        var userCommand = userRequestMapper.of(request);
        var userResult = userFacade.editUserAccount(user, userCommand);
        var response = userResponseMapper.of(userResult);

        return CommonResponse.onSuccess(response);
    }
}
