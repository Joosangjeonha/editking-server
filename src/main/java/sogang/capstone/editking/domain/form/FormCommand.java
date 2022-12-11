package sogang.capstone.editking.domain.form;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import sogang.capstone.editking.common.util.TimestampParser;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.presentation.form.FormRequest;

public class FormCommand {

    @Getter
    @Builder
    @ToString
    public static class RegisterForm {

        private final String company;
        private final String title;
        private final String dueDate;
        private final List<FormRequest.RegisterQuestionRequest> questionList;

        public Form toEntity(User user) {
            TimestampParser timestampParser = new TimestampParser();

            var questions = questionList.stream().map(question -> Question.builder()
                    .idx(question.getIdx())
                    .title(question.getTitle())
                    .maximum(question.getMaximum())
                    .content("")
                    .build()
            ).collect(Collectors.toList());

            return Form.builder()
                    .user(user)
                    .company(company)
                    .title(title)
                    .dueDate(timestampParser.stringToTimestamp(dueDate))
                    .questionList(questions)
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class EditForm {

        private final String company;
        private final String title;
        private final String dueDate;
        private final String content;
        private final List<EditQuestion> questionList;

        public Form toEntity(User user, Long id) {
            TimestampParser timestampParser = new TimestampParser();

            return Form.builder()
                    .id(id)
                    .user(user)
                    .company(company)
                    .title(title)
                    .dueDate(timestampParser.stringToTimestamp(dueDate))
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class EditQuestion {

        private Long idx;
        private String title;
        private Long maximum;
        private String content;

        public Question toEntity() {
            return Question.builder()
                    .idx(idx)
                    .title(title)
                    .maximum(maximum)
                    .content(content)
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class UpdateQuestionRequest {

        private String content;
        private String formStatus;

    }

    @Getter
    @Builder
    @ToString
    public static class AnalyzeSynonymRequest {

        private String keyword;

    }
}
