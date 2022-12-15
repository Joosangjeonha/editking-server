package sogang.capstone.editking.domain.form.event;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sogang.capstone.editking.common.event.Event;
import sogang.capstone.editking.domain.form.Form;
import sogang.capstone.editking.domain.form.Question;

@Getter
@Setter
@NoArgsConstructor
public class SubmittedEvent extends Event {

    private Long formId;
    private List<String> questionList;

    public SubmittedEvent(Form form) {
        super();
        this.formId = form.getId();
        this.questionList = form.getQuestionList().stream().map(Question::getContent).collect(Collectors.toList());
    }

}
