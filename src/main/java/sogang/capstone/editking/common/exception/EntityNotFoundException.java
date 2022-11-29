package sogang.capstone.editking.common.exception;

import org.springframework.http.HttpStatus;
import sogang.capstone.editking.common.response.ErrorCode;

public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException() {
        super(HttpStatus.BAD_REQUEST);
    }

    public EntityNotFoundException(String message) {
        super(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_PARAMETER.getMessage());
    }
}
