package sogang.capstone.editking.domain.interview;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class InterviewInfo {

    @Getter
    @Setter
    @ToString
    public static class AnalyzedInterview {

        private List<AnalyzedInterviewQuestion> interviewList;

    }

    @Getter
    @Builder
    @ToString
    public static class AnalyzedInterviewQuestion {

        private String category;
        private String content;

    }
}
