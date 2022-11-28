package sogang.capstone.editking.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // COMMON
    INVALID_PARAMETER("잘못된 파라미터 입니다."),

    // FORM
    NOT_WRITER_OF_FORM("해당 폼을 작성한 유저가 아닙니다.");

    private final String message;
}
