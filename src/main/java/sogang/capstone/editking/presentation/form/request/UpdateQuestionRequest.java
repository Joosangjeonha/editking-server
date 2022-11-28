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
public class UpdateQuestionRequest {

    @NotNull(message = "content may not be null")
    private String content;

    @NotNull(message = "formStatus may not be null")
    private String formStatus;
}
