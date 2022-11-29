package sogang.capstone.editking.presentation.form;

import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.application.form.FormFacade;
import sogang.capstone.editking.common.response.CommonResponse;
import sogang.capstone.editking.domain.user.User;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormController {

    private final FormFacade formFacade;
    private final FormDtoMapper formDtoMapper;

    @Operation(summary = "자기소개서 생성")
    @PostMapping(value = "", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse registerForm(@AuthenticationPrincipal User user,
            @Valid @RequestBody FormDto.RegisterFormRequest request) {

        var formCommand = formDtoMapper.of(request);
        var response = formFacade.registerForm(user, formCommand);

        return CommonResponse.onSuccess(response);
    }

    @Operation(summary = "자기소개서 삭제")
    @DeleteMapping(value = "/{formId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse deleteForm(@AuthenticationPrincipal User user, @PathVariable Long formId) {

        formFacade.deleteForm(user, formId);

        return CommonResponse.onSuccess(null);
    }

    @Operation(summary = "자기소개서 상세 항목")
    @GetMapping(value = "/{formId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse retrieveForm(@AuthenticationPrincipal User user, @PathVariable Long formId) {

        var formResult = formFacade.retrieveForm(user, formId);
        var response = formDtoMapper.of(formResult);

        return CommonResponse.onSuccess(response);
    }

    @Operation(summary = "자기소개서 수정")
    @PutMapping(value = "/{formId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse editForm(@AuthenticationPrincipal User user, @PathVariable Long formId,
            @Valid @RequestBody FormDto.EditFormRequest request) {

        var formCommand = formDtoMapper.of(request);
        var formResult = formFacade.editForm(formId, user, formCommand);

        return CommonResponse.onSuccess(formResult);
    }

    @Operation(summary = "자기소개서 임시 저장 / 제출 완료")
    @PatchMapping(value = "/{formId}/question/{questionId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse updateQuestionAndFormStatus(@AuthenticationPrincipal User user,
            @PathVariable Long formId, @PathVariable Long questionId,
            @Valid @RequestBody FormDto.UpdateQuestionRequest request) {

        var formCommand = formDtoMapper.of(request);
        formFacade.updateQuestionAndFormStatus(user, formId, questionId, formCommand);

        return CommonResponse.onSuccess(null);
    }
}
