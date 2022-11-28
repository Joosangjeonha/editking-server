package sogang.capstone.editking.presentation.form;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FormDto {

    @Getter
    @Setter
    @ToString
    public static class Main {

        private Long id;
        private String company;
        private String title;
        private String dueDate;
        private List<QuestionMain> questionList;
    }

    @Getter
    @Setter
    @ToString
    public static class QuestionMain {

        private Long idx;
        private String title;
        private Long maximum;
        private String content;
    }

    @Getter
    @Setter
    @ToString
    public static class RegisterFormRequest {

        private String company;
        private String title;
        private String dueDate;
        private List<RegisterQuestionRequest> questionList;
    }

    @Getter
    @Setter
    @ToString
    public static class RegisterQuestionRequest {

        private Long idx;
        private String title;
        private Long maximum;
    }
}
