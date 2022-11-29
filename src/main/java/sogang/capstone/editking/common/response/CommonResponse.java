package sogang.capstone.editking.common.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    HttpStatus code;
    String message;
    T data;

    public static <T> CommonResponse<T> onSuccess(T data) {
        return new CommonResponse<>(HttpStatus.OK, null, data);
    }

    public static CommonResponse onFailure(HttpStatus statusCode, String responseMessage) {
        return new CommonResponse<>(statusCode, responseMessage, null);
    }
}