package sogang.capstone.editking.domain.form.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.form.FormRecommendService;

@Component
@RequiredArgsConstructor
public class SubmittedEventHandler implements ApplicationListener<SubmittedEvent> {

    private final FormRecommendService formRecommendService;

    @Override
    public void onApplicationEvent(SubmittedEvent event) {
        formRecommendService.analyzeInterview(event.getForm());
    }
}
