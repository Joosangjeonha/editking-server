package sogang.capstone.editking.domain.form;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class FormInfo {

    @Getter
    @Builder
    @ToString
    public static class Main {

        private final Long id;
        private final String company;
        private final String title;
        private final String dueDate;
        private final List<Question> questionList;
    }

    @Getter
    @Builder
    @ToString
    public static class Question {

        private final Long idx;
        private final String title;
        private final Long maximum;
        private final String content;
    }
}
