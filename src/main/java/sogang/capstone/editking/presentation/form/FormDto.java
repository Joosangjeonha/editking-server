package sogang.capstone.editking.presentation.form;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FormDto {

    @Getter
    @Setter
    @ToString
    public static class MakeFormRequest {

        @NotNull(message = "company may not be null")
        private String company;

        @NotNull(message = "title may not be null")
        private String title;

        @NotNull(message = "dueDate may not be null")
        private String dueDate;

        @NotNull(message = "code may not be null")
        private List<MakeQuestionRequest> questionList;
    }

    @Getter
    @Setter
    @ToString
    public static class MakeQuestionRequest {

        @NotNull(message = "idx may not be null")
        private Long idx;

        @NotNull(message = "title may not be null")
        private String title;

        @NotNull(message = "maximum may not be null")
        private Long maximum;
    }

    @Getter
    @Builder
    @ToString
    public static class FormResponse {

        private final String formToken;
    }
}
