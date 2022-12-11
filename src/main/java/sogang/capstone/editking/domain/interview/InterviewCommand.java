package sogang.capstone.editking.domain.interview;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class InterviewCommand {

    @Getter
    @Setter
    @ToString
    public static class AnalyzeInterviewRequest {

        private List<String> content;

        public AnalyzeInterviewRequest(List<String> questionList) {
            content = questionList;
        }
    }
}
