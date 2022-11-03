package sogang.capstone.editking.user.application.dto.oauth;

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
public class UserInfoDTO {

    @NotNull(message = "authenticationCode may not be null")
    private String authenticationCode;

    @NotNull(message = "name may not be null")
    private String name;

    @NotNull(message = "provider may not be null")
    private String provider;

    public UserInfoDTO(KakaoUserDTO kakaoUserDTO, String provider) {
        this.authenticationCode = kakaoUserDTO.getAuthenticationCode();
        this.name = kakaoUserDTO.getKakaoAccount().getProfile().getNickname();
        this.provider = provider;
    }

}
