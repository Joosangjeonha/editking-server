package sogang.capstone.editking.domain.user;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.user.UserInfo.Id;
import sogang.capstone.editking.domain.user.UserInfo.Id.IdBuilder;
import sogang.capstone.editking.domain.user.UserInfo.Login;
import sogang.capstone.editking.domain.user.UserInfo.Token;
import sogang.capstone.editking.domain.user.UserInfo.Token.TokenBuilder;
import sogang.capstone.editking.domain.user.auth.KakaoInfo;
import sogang.capstone.editking.domain.user.auth.NaverInfo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-29T20:28:07+0900",
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
    public Token of(String accessToken) {
        if ( accessToken == null ) {
            return null;
        }

        TokenBuilder token = Token.builder();

        token.accessToken( accessToken );

        return token.build();
    }

    @Override
    public Login of(KakaoInfo.User kakaoUser) {
        if ( kakaoUser == null ) {
            return null;
        }

        Login login = new Login();

        login.setAuthenticationCode( kakaoUser.getAuthenticationCode() );

        login.setName( kakaoUser.getKakaoAccount().getProfile().getNickname() );

        return login;
    }

    @Override
    public Login of(NaverInfo.User naverUser) {
        if ( naverUser == null ) {
            return null;
        }

        Login login = new Login();

        login.setAuthenticationCode( naverUser.getResponse().getAuthenticationCode() );
        login.setName( naverUser.getResponse().getNickname() );

        return login;
    }
}
