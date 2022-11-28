package sogang.capstone.editking.domain.form;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import sogang.capstone.editking.common.util.TimestampParser;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.presentation.form.FormDto;

public class FormCommand {

    @Getter
    @Builder
    @ToString
    public static class MakeForm {

        private final User user;
        private final String company;
        private final String title;
        private final String dueDate;
        private final List<FormDto.MakeQuestionRequest> questionList;

        public Form toEntity() {
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
}
