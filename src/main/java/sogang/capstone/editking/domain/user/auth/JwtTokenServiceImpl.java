package sogang.capstone.editking.domain.user.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.domain.user.UserInfo.Id;
import sogang.capstone.editking.domain.user.UserInfo.Token;
import sogang.capstone.editking.domain.user.UserInfoMapper;

@Service
@RequiredArgsConstructor
public class JwtTokenServiceImpl implements JwtTokenService {

    private final CustomUserDetailServiceImpl customUserDetailsService;
    private final UserInfoMapper userInfoMapper;
    @Value("${jwt.secret}")
    private String JWT_SECRET;

    @Override
    public Token encodeToken(String accessToken, String refreshToken) {
        return userInfoMapper.of(accessToken, refreshToken);
    }

    @Override
    public String encodeJwtToken(Id userId) {
        Date now = new Date();

        String token = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("editking")
                .setIssuedAt(now)
                .setSubject(userId.getId().toString())
                .setExpiration(new Date(now.getTime() + Duration.ofDays(50).toMillis()))
                .claim("id", userId.getId())
                .claim("roles", "USER")
                .signWith(SignatureAlgorithm.HS256,
                        Base64.getEncoder().encodeToString(("" + JWT_SECRET).getBytes(
                                StandardCharsets.UTF_8)))
                .compact();
        return token;
    }

    @Override
    public String encodeJwtRefreshToken(Id userId) {
        Date now = new Date();
        return Jwts.builder()
                .setIssuedAt(now)
                .setSubject(userId.getId().toString())
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(20160).toMillis()))
                .claim("id", userId.getId())
                .claim("roles", "USER")
                .signWith(SignatureAlgorithm.HS256,
                        Base64.getEncoder().encodeToString(("" + JWT_SECRET).getBytes(
                                StandardCharsets.UTF_8)))
                .compact();
    }

    @Override
    public Long getUserIdFromJwtToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(Base64.getEncoder().encodeToString(("" + JWT_SECRET).getBytes(
                        StandardCharsets.UTF_8)))
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    @Override
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(
                this.getUserIdFromJwtToken(token).toString());
        return new UsernamePasswordAuthenticationToken(userDetails, "",
                userDetails.getAuthorities());
    }

    @Override
    public Boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(("" + JWT_SECRET).getBytes(
                            StandardCharsets.UTF_8))).parseClaimsJws(token);

            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String getToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

}
