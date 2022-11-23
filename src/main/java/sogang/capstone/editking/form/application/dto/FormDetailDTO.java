package sogang.capstone.editking.form.application.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class FormDetailDTO {

    @NotNull(message = "id may not be null")
    private Long id;

    @NotNull(message = "questionList may not be null")
    private List<QuestionDTO> questionList;

    public FormDetailDTO(Long id, List<QuestionDTO> questionDTOList) {
        this.id = id;
        this.questionList = questionDTOList;
    }

}
