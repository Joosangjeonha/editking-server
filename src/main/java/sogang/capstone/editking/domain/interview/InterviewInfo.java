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

    @Getter
    @Setter
    @ToString
    public static class InterviewMain {

        private final List<InterviewQuestion> interviewList;

        public InterviewMain(List<InterviewQuestion> interviewList) {
            this.interviewList = interviewList;
        }
    }

    @Getter
    @Setter
    @ToString
    public static class InterviewQuestion {

        private final String category;
        private final String content;

        public InterviewQuestion(Interview interview) {
            this.category = interview.getCategory().getValue();
            this.content = interview.getContent();
        }
    }
}
