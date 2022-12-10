package sogang.capstone.editking.domain.form.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.interview.InterviewService;

@Component
@RequiredArgsConstructor
public class SubmittedEventHandler implements ApplicationListener<SubmittedEvent> {

    private final InterviewService interviewService;

    @Async
    @Override
    public void onApplicationEvent(SubmittedEvent event) {
        interviewService.analyzeInterview(event.getForm());
    }
}
