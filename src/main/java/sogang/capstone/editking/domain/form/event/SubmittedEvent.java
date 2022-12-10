package sogang.capstone.editking.domain.form.event;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import sogang.capstone.editking.domain.form.Form;
import sogang.capstone.editking.domain.form.FormInfo;
import sogang.capstone.editking.domain.form.Question;

@Getter
public class SubmittedEvent extends ApplicationEvent {

    private FormInfo.Id formId;
    private List<String> questionList;

    public SubmittedEvent(Object object, Form form) {
        super(object);
        this.formId = FormInfo.Id.builder().id(form.getId()).build();
        this.questionList = form.getQuestionList().stream().map(Question::getContent).collect(Collectors.toList());
    }

}
