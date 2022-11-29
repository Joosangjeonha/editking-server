package sogang.capstone.editking.presentation.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserResponse {

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
    public static class Token {

        private String accessToken;
    }

}
