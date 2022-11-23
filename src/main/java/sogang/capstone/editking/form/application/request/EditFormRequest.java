package sogang.capstone.editking.form.application.request;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EditFormRequest {
    

    @NotNull(message = "company may not be null")
    private String company;

    @NotNull(message = "title may not be null")
    private String title;

    @NotNull(message = "dueDate may not be null")
    private String dueDate;

    @NotNull(message = "code may not be null")
    private List<EditQuestionRequest> questionList;
}
