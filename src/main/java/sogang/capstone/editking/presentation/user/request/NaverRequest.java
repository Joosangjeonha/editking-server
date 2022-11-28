package sogang.capstone.editking.presentation.user.request;

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
public class NaverRequest {

    @NotNull(message = "code may not be null")
    private String code;

    @NotNull(message = "state may not be null")
    private String state;
}
