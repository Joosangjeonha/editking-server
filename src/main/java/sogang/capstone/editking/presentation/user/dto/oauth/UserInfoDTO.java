package sogang.capstone.editking.presentation.user.dto.oauth;

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

    public UserInfoDTO(NaverUserDTO naverUserDTO, String provider) {
        this.authenticationCode = naverUserDTO.getResponse().getAuthenticationCode();
        this.name = naverUserDTO.getResponse().getNickname();
        this.provider = provider;
    }
}
