package sogang.capstone.editking.domain.form.event;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import sogang.capstone.editking.common.event.Event;
import sogang.capstone.editking.domain.form.Form;
import sogang.capstone.editking.domain.form.FormInfo;
import sogang.capstone.editking.domain.form.Question;

@Getter
public class SubmittedEvent extends Event {

    private FormInfo.Id formId;
    private List<String> questionList;

    public SubmittedEvent(Form form) {
        this.formId = FormInfo.Id.builder().id(form.getId()).build();
        this.questionList = form.getQuestionList().stream().map(Question::getContent).collect(Collectors.toList());
    }

}
