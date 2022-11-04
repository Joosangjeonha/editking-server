package sogang.capstone.editking.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.global.config.CommonResponse;
import sogang.capstone.editking.user.application.UserService;
import sogang.capstone.editking.user.application.dto.TokenDTO;
import sogang.capstone.editking.user.application.dto.UserDTO;
import sogang.capstone.editking.user.domain.User;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping(value = "/logout", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<TokenDTO> logout(@AuthenticationPrincipal User user) {

        userService.userLogout(user);

        return CommonResponse.onSuccess(null);
    }

    @GetMapping(value = "", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<UserDTO> getUserAccount(@AuthenticationPrincipal User user) {

        UserDTO userDTO = new UserDTO(user);

        return CommonResponse.onSuccess(userDTO);
    }
}
