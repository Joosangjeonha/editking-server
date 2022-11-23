package sogang.capstone.editking.form.application.request;

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

    @NotNull(message = "newIdx may not benull")
    private Long newIdx;

    @NotNull(message = "idx may not be null")
    private Long idx;

    @NotNull(message = "title may not be null")
    private String title;

    @NotNull(message = "maximum may not be null")
    private Long maximum;
}
