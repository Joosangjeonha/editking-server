package sogang.capstone.editking.form.application.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sogang.capstone.editking.form.domain.Form;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FormDTO {

    @NotNull(message = "company may not be null")
    private String company;

    @NotNull(message = "title may not be null")
    private String title;

    @NotNull(message = "dueDate may not be null")
    private String dueDate;

    @NotNull(message = "code may not be null")
    private List<QuestionDTO> questionList;

    public FormDTO(Form form, List<QuestionDTO> questionDTOList) {
        this.company = form.getCompany().getName();
        this.title = form.getTitle();
        this.dueDate = form.getDueDate().toString();
        this.questionList = questionDTOList;
    }
}
