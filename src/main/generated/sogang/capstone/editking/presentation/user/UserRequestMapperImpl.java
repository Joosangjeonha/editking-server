package sogang.capstone.editking.presentation.user;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.user.UserCommand.KakaoRequest.KakaoRequestBuilder;
import sogang.capstone.editking.domain.user.UserCommand.NaverRequest;
import sogang.capstone.editking.domain.user.UserCommand.NaverRequest.NaverRequestBuilder;
import sogang.capstone.editking.presentation.user.UserRequest.KakaoRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-30T00:26:40+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class UserRequestMapperImpl implements UserRequestMapper {

    @Override
    public sogang.capstone.editking.domain.user.UserCommand.KakaoRequest of(KakaoRequest request) {
        if ( request == null ) {
            return null;
        }

        KakaoRequestBuilder kakaoRequest = sogang.capstone.editking.domain.user.UserCommand.KakaoRequest.builder();

        kakaoRequest.code( request.getCode() );

        return kakaoRequest.build();
    }

    @Override
    public NaverRequest of(sogang.capstone.editking.presentation.user.UserRequest.NaverRequest request) {
        if ( request == null ) {
            return null;
        }

        NaverRequestBuilder naverRequest = NaverRequest.builder();

        naverRequest.code( request.getCode() );
        naverRequest.state( request.getState() );

        return naverRequest.build();
    }
}
