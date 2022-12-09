package sogang.capstone.editking.domain.form.event;

import java.util.List;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import sogang.capstone.editking.domain.form.Question;

@Getter
public class SubmittedEvent extends ApplicationEvent {

    private List<Question> questionList;

    public SubmittedEvent(Object object, List<Question> questionList) {
        super(object);
        this.questionList = questionList;
    }

}
