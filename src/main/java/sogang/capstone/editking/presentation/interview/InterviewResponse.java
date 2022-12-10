package sogang.capstone.editking.presentation.interview;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class InterviewResponse {

    @Getter
    @Setter
    @ToString
    public static class InterviewMain {

        private List<InterviewQuestion> interviewList;

    }

    @Getter
    @Builder
    @ToString
    public static class InterviewQuestion {

        private String category;
        private String content;

    }
}
