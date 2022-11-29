package sogang.capstone.editking.domain.user.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class NaverInfo {

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

        @JsonProperty("result_code")
        private String resultCode;
        private String message;
        private Profile response;

    }

    @Getter
    @Setter
    @ToString
    public static class Profile {

        @JsonProperty("id")
        private String authenticationCode;
        @JsonProperty("name")
        private String nickname;
        @JsonProperty("profile_image")
        private String imageUrl;

    }
}
