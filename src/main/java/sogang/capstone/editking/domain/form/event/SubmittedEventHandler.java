package sogang.capstone.editking.domain.form.event;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import sogang.capstone.editking.domain.interview.InterviewService;

@Component
@RequiredArgsConstructor
public class SubmittedEventHandler {

    private final InterviewService interviewService;

    @Async
    @TransactionalEventListener(
            classes = SubmittedEvent.class,
            phase = TransactionPhase.AFTER_COMMIT
    )
    public void handle(SubmittedEvent event) {
        interviewService.analyzeInterview(event);
    }
}
