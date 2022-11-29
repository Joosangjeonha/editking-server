package sogang.capstone.editking.domain.form;

import java.sql.Timestamp;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FormInfo {

    @Getter
    @Builder
    @ToString
    public static class Main {

        private final Long id;
        private final String company;
        private final String title;
        private final Timestamp dueDate;
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

    @Getter
    @Setter
    @ToString
    public static class CatalogMain {

        private final List<CatalogForm> formList;

        public CatalogMain(List<CatalogForm> formList) {
            this.formList = formList;
        }
    }

    @Getter
    @Setter
    @ToString
    public static class CatalogForm {

        private final Long id;
        private final String company;
        private final String title;
        private final Timestamp dueDate;

        public CatalogForm(Form form) {
            this.id = form.getId();
            this.company = form.getCompany();
            this.title = form.getTitle();
            this.dueDate = form.getDueDate();
        }
    }
}
