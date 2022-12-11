package sogang.capstone.editking.domain.interview;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

public class InterviewCommand {

    @Getter
    @Setter
    @ToString
    public static class AnalyzeInterviewRequest {

        private String context;

        public AnalyzeInterviewRequest(List<String> questionList) {
            context = StringUtils.join(questionList, "");
        }
    }
}
