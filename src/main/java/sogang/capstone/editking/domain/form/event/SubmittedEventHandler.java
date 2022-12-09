package sogang.capstone.editking.domain.form.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SubmittedEventHandler implements ApplicationListener<SubmittedEvent> {

    @Override
    public void onApplicationEvent(SubmittedEvent event) {

    }
}
