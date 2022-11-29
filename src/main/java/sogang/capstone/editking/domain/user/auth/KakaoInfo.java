package sogang.capstone.editking.domain.user.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class KakaoInfo {

    @Getter
    @Setter
    @ToString
    public static class Token {

        @JsonProperty("access_token")
        private String accessToken;
        @JsonProperty("refresh_token")
        private String refreshToken;
    }

    @Getter
    @Setter
    @ToString
    public static class User {

        @JsonProperty("id")
        private String authenticationCode;
        @JsonProperty("connected_at")
        private Timestamp connectedAt;
        @JsonProperty("kakao_account")
        private Account kakaoAccount;

    }

    @Getter
    @Setter
    @ToString
    public static class Account {

        private Profile profile;

    }

    @Getter
    @Setter
    @ToString
    public static class Profile {

        private String nickname;

    }
}
