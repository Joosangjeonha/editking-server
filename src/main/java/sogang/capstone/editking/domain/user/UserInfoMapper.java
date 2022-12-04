package sogang.capstone.editking.domain.user;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import sogang.capstone.editking.domain.user.auth.KakaoInfo;
import sogang.capstone.editking.domain.user.auth.NaverInfo;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserInfoMapper {

    UserInfo.Id of(User user);

    UserInfo.Id of(Long id);

    UserInfo.Token of(String accessToken, String refreshToken);

    @Mappings({
            @Mapping(source = "kakaoUser.authenticationCode", target = "authenticationCode"),
            @Mapping(expression = "java(kakaoUser.getKakaoAccount().getProfile().getNickname())", target = "name"),
    })
    UserInfo.Login of(KakaoInfo.User kakaoUser);

    @Mappings({
            @Mapping(expression = "java(naverUser.getResponse().getAuthenticationCode())", target = "authenticationCode"),
            @Mapping(expression = "java(naverUser.getResponse().getNickname())", target = "name"),
    })
    UserInfo.Login of(NaverInfo.User naverUser);

}
