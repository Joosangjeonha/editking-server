package sogang.capstone.editking.presentation.interview;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.application.interview.InterviewFacade;
import sogang.capstone.editking.common.response.CommonResponse;
import sogang.capstone.editking.domain.user.User;

@RestController
@RequestMapping("/interview")
@RequiredArgsConstructor
public class InterviewController {

    private final InterviewFacade interviewFacade;
    private final InterviewResponseMapper interviewResponseMapper;

    @Operation(summary = "면접 질문 분석")
    @GetMapping(value = "/form/{formId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse recommendInterview(@AuthenticationPrincipal User user, @PathVariable Long formId) {

        var interviewResult = interviewFacade.recommendInterview(formId);
        var response = interviewResponseMapper.of(interviewResult);

        return CommonResponse.onSuccess(response);
    }
}
