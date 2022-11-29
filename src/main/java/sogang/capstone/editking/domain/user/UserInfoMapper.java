package sogang.capstone.editking.domain.user;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserInfoMapper {

    UserInfo.Id of(User user);

    UserInfo.Token of(String accessToken);

    @Mappings({
            @Mapping(source = "kakaoUser.authenticationCode", target = "authenticationCode"),
            @Mapping(expression = "java(kakaoUser.getKakaoAccount().getProfile().getNickname())", target = "name"),
    })
    UserInfo.Login of(KakaoInfo.User kakaoUser);
}
