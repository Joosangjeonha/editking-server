package sogang.capstone.editking.form.presentation;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.form.application.FormService;
import sogang.capstone.editking.global.config.CommonResponse;
import sogang.capstone.editking.user.application.dto.TokenDTO;
import sogang.capstone.editking.user.domain.User;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormController {

    private final FormService formService;

    @Operation(summary = "자기소개서 생성")
    @PostMapping(value = "", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<TokenDTO> createNewForm(@AuthenticationPrincipal User user) {

        return CommonResponse.onSuccess(null);
    }
}
