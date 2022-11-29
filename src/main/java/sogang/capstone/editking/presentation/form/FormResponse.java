package sogang.capstone.editking.presentation.form;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FormResponse {

    @Getter
    @Setter
    @ToString
    public static class Main {

        private Long id;
        private String company;
        private String title;
        private String dueDate;
        private List<Question> questionList;
    }

    @Getter
    @Setter
    @ToString
    public static class Question {

        private Long idx;
        private String title;
        private Long maximum;
        private String content;
    }

    @Getter
    @Setter
    @ToString
    public static class CatalogMain {

        private List<CatalogForm> formList;
    }

    @Getter
    @Setter
    @ToString
    public static class CatalogForm {

        private Long id;
        private String company;
        private String title;
        private String dueDate;
    }
}
