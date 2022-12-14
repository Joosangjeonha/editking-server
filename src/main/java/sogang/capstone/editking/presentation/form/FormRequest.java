package sogang.capstone.editking.presentation.form;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FormRequest {

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

    @Getter
    @Setter
    @ToString
    public static class EditFormRequest {

        private String company;
        private String title;
        private String dueDate;
        private String content;
        private List<EditQuestionRequest> questionList;
    }

    @Getter
    @Setter
    @ToString
    public static class EditQuestionRequest {

        private Long idx;
        private String title;
        private Long maximum;
        private String content;
    }

    @Getter
    @Setter
    @ToString
    public static class UpdateQuestionRequest {

        private String content;
        private String formStatus;
    }
}
