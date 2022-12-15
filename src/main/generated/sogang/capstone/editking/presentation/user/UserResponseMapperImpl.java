package sogang.capstone.editking.presentation.user;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.domain.user.UserInfo.Token;
import sogang.capstone.editking.presentation.user.UserResponse.Main;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T03:39:40+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class UserResponseMapperImpl implements UserResponseMapper {

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
    public Main of(sogang.capstone.editking.domain.user.UserInfo.Main mainResult) {
        if ( mainResult == null ) {
            return null;
        }

        Main main = new Main();

        main.setName( mainResult.getName() );
        main.setPlan( mainResult.getPlan() );

        return main;
    }

    @Override
    public sogang.capstone.editking.presentation.user.UserResponse.Token of(Token token) {
        if ( token == null ) {
            return null;
        }

        sogang.capstone.editking.presentation.user.UserResponse.Token token1 = new sogang.capstone.editking.presentation.user.UserResponse.Token();

        token1.setAccessToken( token.getAccessToken() );

        return token1;
    }
}
