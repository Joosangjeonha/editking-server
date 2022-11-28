package sogang.capstone.editking.presentation.form.request;

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
public class EditQuestionRequest {

    @NotNull(message = "idx may not be null")
    private Long idx;

    @NotNull(message = "title may not be null")
    private String title;

    @NotNull(message = "maximum may not be null")
    private Long maximum;

    @NotNull(message = "content may not be null")
    private String content;
}
