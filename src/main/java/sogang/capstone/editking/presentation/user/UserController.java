package sogang.capstone.editking.presentation.user;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.common.config.CommonResponse;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.domain.user.UserService;
import sogang.capstone.editking.presentation.user.dto.TokenDTO;
import sogang.capstone.editking.presentation.user.dto.UserDTO;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "로그아웃")
    @PatchMapping(value = "/logout", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<TokenDTO> logout(@AuthenticationPrincipal User user) {

        userService.userLogout(user);

        return CommonResponse.onSuccess(null);
    }

    @Operation(summary = "유저 정보")
    @GetMapping(value = "", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<UserDTO> getUserAccount(@AuthenticationPrincipal User user) {

        UserDTO userDTO = new UserDTO(user);

        return CommonResponse.onSuccess(userDTO);
    }
}
