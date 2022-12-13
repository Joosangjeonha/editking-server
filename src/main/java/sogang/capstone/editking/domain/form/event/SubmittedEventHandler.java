package sogang.capstone.editking.domain.form.event;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.common.event.EventHandler;
import sogang.capstone.editking.domain.interview.InterviewService;

@Component
@RequiredArgsConstructor
public class SubmittedEventHandler implements EventHandler<SubmittedEvent> {

    private final InterviewService interviewService;

    @Async
    @Override
    public void handle(SubmittedEvent event) {
        interviewService.analyzeInterview(event);
    }
}
