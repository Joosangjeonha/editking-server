package sogang.capstone.editking.presentation.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserRequest {

    @Getter
    @Setter
    @ToString
    public static class KakaoRequest {

        private String code;
    }

    @Getter
    @Setter
    @ToString
    public static class NaverRequest {

        private String code;
        private String state;
    }

    @Getter
    @Setter
    @ToString
    public static class EditAccountRequest {

        private String name;
        private String plan;
    }
}
