package sogang.capstone.editking.domain.user;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.user.UserInfo.Id;
import sogang.capstone.editking.domain.user.UserInfo.Id.IdBuilder;
import sogang.capstone.editking.domain.user.UserInfo.Login;
import sogang.capstone.editking.domain.user.UserInfo.Token;
import sogang.capstone.editking.domain.user.UserInfo.Token.TokenBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-05T02:45:09+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class UserInfoMapperImpl implements UserInfoMapper {

    @Override
    public Id of(User user) {
        if ( user == null ) {
            return null;
        }

        IdBuilder id = Id.builder();

        id.id( user.getId() );

        return id.build();
    }

    @Override
    public Token of(String accessToken, String refreshToken) {
        if ( accessToken == null && refreshToken == null ) {
            return null;
        }

        TokenBuilder token = Token.builder();

        if ( accessToken != null ) {
            token.accessToken( accessToken );
        }
        if ( refreshToken != null ) {
            token.refreshToken( refreshToken );
        }

        return token.build();
    }

    @Override
    public Login of(sogang.capstone.editking.domain.user.auth.KakaoInfo.User kakaoUser) {
        if ( kakaoUser == null ) {
            return null;
        }

        Login login = new Login();

        login.setAuthenticationCode( kakaoUser.getAuthenticationCode() );

        login.setName( kakaoUser.getKakaoAccount().getProfile().getNickname() );

        return login;
    }

    @Override
    public Login of(sogang.capstone.editking.domain.user.auth.NaverInfo.User naverUser) {
        if ( naverUser == null ) {
            return null;
        }

        Login login = new Login();

        login.setAuthenticationCode( naverUser.getResponse().getAuthenticationCode() );
        login.setName( naverUser.getResponse().getNickname() );

        return login;
    }
}
