package sogang.capstone.editking.domain.form.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import sogang.capstone.editking.domain.form.Form;

@Getter
public class SubmittedEvent extends ApplicationEvent {

    private Form form;

    public SubmittedEvent(Object object, Form form) {
        super(object);
        this.form = form;
    }

}
