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

}
