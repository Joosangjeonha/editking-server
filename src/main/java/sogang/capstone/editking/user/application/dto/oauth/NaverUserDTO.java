package sogang.capstone.editking.user.application.dto.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class NaverUserDTO {

    @JsonProperty("result_code")
    private String resultCode;

    @NotNull(message = "message may not be null")
    private String message;

    @NotNull(message = "response may not be null")
    private NaverProfileDTO response;

}