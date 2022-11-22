package sogang.capstone.editking.form.presentation;

import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.form.application.FormService;
import sogang.capstone.editking.form.application.dto.FormDTO;
import sogang.capstone.editking.form.application.request.NewFormRequest;
import sogang.capstone.editking.global.config.CommonResponse;
import sogang.capstone.editking.user.domain.User;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormController {

    private final FormService formService;

    @Operation(summary = "자기소개서 생성")
    @PostMapping(value = "", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<FormDTO> createNewForm(@AuthenticationPrincipal User user,
            @Valid @RequestBody NewFormRequest newFormRequest) {

        FormDTO formDTO = formService.createFormWithNewFormRequest(user, newFormRequest);

        return CommonResponse.onSuccess(formDTO);
    }

    @Operation(summary = "자기소개서 삭제")
    @DeleteMapping(value = "/{formId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<FormDTO> deleteForm(@AuthenticationPrincipal User user, @PathVariable Long formId) {

        formService.validateWriterOfForm(user, formId);
        formService.deleteForm(formId);

        return CommonResponse.onSuccess(null);
    }
}
