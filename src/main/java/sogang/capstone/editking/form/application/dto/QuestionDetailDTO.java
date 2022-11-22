package sogang.capstone.editking.form.application.dto;

import javax.validation.constraints.NotNull;
import sogang.capstone.editking.form.domain.Question;

public class QuestionDetailDTO {

    @NotNull(message = "idx may not be null")
    private Long idx;

    @NotNull(message = "title may not be null")
    private String title;

    @NotNull(message = "maximum may not be null")
    private Long maximum;

    @NotNull(message = "content may not be null")
    private String content;

    public QuestionDetailDTO(Question question) {
        this.idx = question.getIdx();
        this.title = question.getTitle();
        this.maximum = question.getMaximum();
        this.content = question.getContent();
    }

}