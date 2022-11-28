package sogang.capstone.editking.presentation.user.dto.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
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
public class KakaoUserDTO {

    @NotNull(message = "authenticationCode may not be null")
    @JsonProperty("id")
    private String authenticationCode;

    @NotNull(message = "connectedAt may not be null")
    @JsonProperty("connected_at")
    private Timestamp connectedAt;

    @NotNull(message = "kakaoAccount may not be null")
    @JsonProperty("kakao_account")
    private KakaoAccountDTO kakaoAccount;

}
