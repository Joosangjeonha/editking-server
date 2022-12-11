package sogang.capstone.editking.application.interview;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.domain.interview.InterviewInfo;
import sogang.capstone.editking.domain.interview.InterviewService;

@Service
@RequiredArgsConstructor
public class InterviewFacade {

    private final InterviewService interviewService;

    public InterviewInfo.InterviewMain recommendInterview(Long formId) {
        return interviewService.recommendInterview(formId);
    }
}
