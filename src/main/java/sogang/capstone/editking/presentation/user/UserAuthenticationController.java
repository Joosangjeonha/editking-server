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
    public CommonResponse loginWithKakao(@Valid @RequestBody UserRequest.KakaoRequest kakaoRequest) {

        var userCommand = userRequestMapper.of(kakaoRequest);
        var userResult = userAuthenticationFacade.loginWithKakao(userCommand);
        var response = userResponseMapper.of(userResult);

        return CommonResponse.onSuccess(response);
    }

    @Operation(summary = "네이버 로그인")
    @PostMapping(value = "/naver", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse loginWithNaver(@Valid @RequestBody UserRequest.NaverRequest naverRequest) {

        var userCommand = userRequestMapper.of(naverRequest);
        var userResult = userAuthenticationFacade.loginWithNaver(userCommand);
        var response = userResponseMapper.of(userResult);

        return CommonResponse.onSuccess(response);
    }
}
