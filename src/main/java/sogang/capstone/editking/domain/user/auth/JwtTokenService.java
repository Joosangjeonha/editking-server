package sogang.capstone.editking.domain.user.auth;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import sogang.capstone.editking.domain.user.UserInfo.Id;
import sogang.capstone.editking.domain.user.UserInfo.Token;


public interface JwtTokenService {

    public Token encodeToken(String accessToken, String refreshToken);

    public String encodeJwtToken(Id userId);

    public String encodeJwtRefreshToken(Id userId);

    public Long getUserIdFromJwtToken(String token);

    public Authentication getAuthentication(String token);

    public Boolean validateToken(String token);

    public String getToken(HttpServletRequest request);

}
