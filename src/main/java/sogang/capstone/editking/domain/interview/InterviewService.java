package sogang.capstone.editking.domain.interview;

import sogang.capstone.editking.domain.form.event.SubmittedEvent;

public interface InterviewService {

    public void analyzeInterview(SubmittedEvent event);

    public InterviewInfo.InterviewMain recommendInterview(Long id);
}
