package sogang.capstone.editking.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserInfo {

    @Getter
    @Setter
    @ToString
    public static class Main {

        private String name;
        private String plan;
    }

    @Getter
    @Setter
    @ToString
    public static class Login {

        private String authenticationCode;
        private String name;

    }

    @Getter
    @Builder
    @ToString
    public static class Id {

        private final Long id;

    }

    @Getter
    @Builder
    @ToString
    public static class Token {

        private final String accessToken;
        private final String refreshToken;

    }
}
