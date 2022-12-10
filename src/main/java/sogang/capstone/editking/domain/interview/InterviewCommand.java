package sogang.capstone.editking.domain.interview;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sogang.capstone.editking.domain.form.Form;
import sogang.capstone.editking.domain.form.Question;

public class InterviewCommand {

    @Getter
    @Setter
    @ToString
    public static class AnalyzeInterviewRequest {

        private List<String> content;

        public AnalyzeInterviewRequest(Form form) {
            content = form.getQuestionList().stream().map(Question::getContent).collect(Collectors.toList());
        }
    }
}
