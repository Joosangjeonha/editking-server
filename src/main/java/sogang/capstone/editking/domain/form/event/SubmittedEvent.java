package sogang.capstone.editking.domain.form.event;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sogang.capstone.editking.domain.form.Question;

@Getter
@AllArgsConstructor
public class SubmittedEvent {

    private List<Question> questionList;
    
}
