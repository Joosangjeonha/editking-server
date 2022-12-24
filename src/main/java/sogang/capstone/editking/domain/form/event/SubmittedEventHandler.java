package sogang.capstone.editking.domain.form.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.interview.InterviewService;

@Component
@RequiredArgsConstructor
public class SubmittedEventHandler {

    private final InterviewService interviewService;

    @EventListener(SubmittedEvent.class)
    public void handle(SubmittedEvent event) {
        interviewService.analyzeInterview(event);
    }
}
