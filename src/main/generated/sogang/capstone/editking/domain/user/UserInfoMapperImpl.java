package sogang.capstone.editking.domain.user;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.user.UserInfo.Id;
import sogang.capstone.editking.domain.user.UserInfo.Id.IdBuilder;
import sogang.capstone.editking.domain.user.UserInfo.Login;
import sogang.capstone.editking.domain.user.UserInfo.Main;
import sogang.capstone.editking.domain.user.UserInfo.Token;
import sogang.capstone.editking.domain.user.UserInfo.Token.TokenBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-13T18:37:58+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class UserInfoMapperImpl implements UserInfoMapper {

    @Override
    public Main of(User user) {
        if ( user == null ) {
            return null;
        }

        Main main = new Main();

        main.setName( user.getName() );
        if ( user.getPlan() != null ) {
            main.setPlan( user.getPlan().name() );
        }

        return main;
    }

    @Override
    public Id of(Long id) {
        if ( id == null ) {
            return null;
        }

        IdBuilder id1 = Id.builder();

        id1.id( id );

        return id1.build();
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
