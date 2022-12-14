package sogang.capstone.editking.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class UserCommand {

    @Getter
    @Builder
    @ToString
    public static class KakaoRequest {

        private final String code;

    }

    @Getter
    @Builder
    @ToString
    public static class NaverRequest {

        private final String code;
        private final String state;

    }

    @Getter
    @Builder
    @ToString
    public static class EditAccountRequest {

        private final String name;
        private final String plan;

    }
}
