package sogang.capstone.editking.domain.form;

import java.sql.Timestamp;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sogang.capstone.editking.domain.form.interview.Interview;

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

    @Getter
    @Builder
    @ToString
    public static class SynonymMain {

        private final String word;
        private final List<String> synonymList;

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
