package sogang.capstone.editking.form.application.dto;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import sogang.capstone.editking.form.domain.Question;

public class FormDetailDTO {

    @NotNull(message = "id may not be null")
    private Long id;

    @NotNull(message = "title may not be null")
    private List<QuestionDetailDTO> questionList;

    public FormDetailDTO(Long id, List<Question> questionList) {
        this.id = id;
        this.questionList = questionList.stream().map(QuestionDetailDTO::new).collect(Collectors.toList());
    }

}
