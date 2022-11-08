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
public class QuestionRequest {

    @NotNull(message = "index may not be null")
    private Long index;

    @NotNull(message = "title may not be null")
    private String title;

    @NotNull(message = "limit may not be null")
    private Long limit;
}
