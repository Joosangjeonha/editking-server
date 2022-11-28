package sogang.capstone.editking.presentation.user.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {

    @NotNull(message = "accessToken may not be null")
    private String accessToken;

}
