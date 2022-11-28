package sogang.capstone.editking.presentation.form.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sogang.capstone.editking.domain.form.Question;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

    @NotNull(message = "idx may not be null")
    private Long idx;

    @NotNull(message = "title may not be null")
    private String title;

    @NotNull(message = "maximum may not be null")
    private Long maximum;

    @NotNull(message = "content may not be null")
    private String content;

    public QuestionDTO(Question question) {
        this.idx = question.getIdx();
        this.title = question.getTitle();
        this.maximum = question.getMaximum();
        this.content = question.getContent();
    }
}
