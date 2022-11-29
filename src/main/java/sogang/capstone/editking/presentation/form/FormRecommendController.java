package sogang.capstone.editking.presentation.form;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.application.form.FormRecommendFacade;
import sogang.capstone.editking.common.response.CommonResponse;
import sogang.capstone.editking.domain.user.User;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormRecommendController {

    private final FormRecommendFacade formRecommendFacade;
    private final FormResponseMapper formResponseMapper;

    @Operation(summary = "단어 분석")
    @GetMapping(value = "/question", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse recommendSynonym(@AuthenticationPrincipal User user, @RequestParam String word) {

        var formResult = formRecommendFacade.recommendSynonym(word);
        var response = formResponseMapper.of(formResult);

        return CommonResponse.onSuccess(response);
    }

    @Operation(summary = "면접 질문 분석")
    @GetMapping(value = "/{formId}/interview", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse recommendInterview(@AuthenticationPrincipal User user, @PathVariable Long formId) {

        var formResult = formRecommendFacade.recommendInterview(formId);
        var response = formResponseMapper.of(formResult);

        return CommonResponse.onSuccess(response);
    }
}
