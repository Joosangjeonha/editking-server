package sogang.capstone.editking.form.presentation;

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
import sogang.capstone.editking.form.application.FormService;
import sogang.capstone.editking.form.application.dto.FormDTO;
import sogang.capstone.editking.form.application.dto.FormDetailDTO;
import sogang.capstone.editking.form.application.request.EditFormRequest;
import sogang.capstone.editking.form.application.request.NewFormRequest;
import sogang.capstone.editking.form.application.request.UpdateQuestionRequest;
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

        formService.deleteForm(user, formId);

        return CommonResponse.onSuccess(null);
    }

    @Operation(summary = "자기소개서 상세 항목")
    @GetMapping(value = "/{formId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<FormDetailDTO> readFormDetail(@AuthenticationPrincipal User user, @PathVariable Long formId) {

        FormDTO formDTO = formService.readFormDetail(user, formId);

        return CommonResponse.onSuccess(new FormDetailDTO(formDTO.getId(), formDTO.getQuestionList()));
    }

    @Operation(summary = "자기소개서 수정")
    @PutMapping(value = "/{formId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<FormDTO> updateForm(@AuthenticationPrincipal User user, @PathVariable Long formId,
            @Valid @RequestBody EditFormRequest editFormRequest) {

        FormDTO formDTO = formService.updateForm(user, formId, editFormRequest);

        return CommonResponse.onSuccess(formDTO);
    }

    @Operation(summary = "자기소개서 임시 저장 / 제출 완료")
    @PatchMapping(value = "/{formId}/question/{questionId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<FormDTO> updateQuestion(@AuthenticationPrincipal User user, @PathVariable Long formId,
            @PathVariable Long questionId, @Valid @RequestBody UpdateQuestionRequest updateQuestionRequest) {

        FormDTO formDTO = formService.updateQuestion(user, formId, questionId, updateQuestionRequest);

        return CommonResponse.onSuccess(formDTO);
    }
}
