package sogang.capstone.editking.user.application;

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
import sogang.capstone.editking.user.application.dto.UserIdDTO;

@RequiredArgsConstructor
@Service
public class JwtTokenService {

    private final CustomUserDetailServiceImpl customUserDetailsService;
    @Value("${jwt.secret}")
    private String JWT_SECRET;

    public String encodeJwtToken(UserIdDTO userIdDTO) {
        Date now = new Date();

        return Jwts.builder()
            .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
            .setIssuer("bankids")
            .setIssuedAt(now)
            .setSubject(userIdDTO.getId().toString())
            .setExpiration(new Date(now.getTime() + Duration.ofDays(180).toMillis()))
            .claim("id", userIdDTO.getId())
            .claim("roles", "USER")
            .signWith(SignatureAlgorithm.HS256,
                Base64.getEncoder().encodeToString(("" + JWT_SECRET).getBytes(
                    StandardCharsets.UTF_8)))
            .compact();
    }

    public String encodeJwtRefreshToken(UserIdDTO userIdDTO) {
        Date now = new Date();
        return Jwts.builder()
            .setIssuedAt(now)
            .setSubject(userIdDTO.getId().toString())
            .setExpiration(new Date(now.getTime() + Duration.ofMinutes(20160).toMillis()))
            .claim("id", userIdDTO.getId())
            .claim("roles", "USER")
            .signWith(SignatureAlgorithm.HS256,
                Base64.getEncoder().encodeToString(("" + JWT_SECRET).getBytes(
                    StandardCharsets.UTF_8)))
            .compact();
    }

    public Long getUserIdFromJwtToken(String token) {
        Claims claims = Jwts.parser()
            .setSigningKey(Base64.getEncoder().encodeToString(("" + JWT_SECRET).getBytes(
                StandardCharsets.UTF_8)))
            .parseClaimsJws(token)
            .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(
            this.getUserIdFromJwtToken(token).toString());
        return new UsernamePasswordAuthenticationToken(userDetails, "",
            userDetails.getAuthorities());
    }

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

    public String getToken(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }

}