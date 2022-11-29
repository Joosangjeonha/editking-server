package sogang.capstone.editking.presentation.user;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sogang.capstone.editking.domain.user.UserCommand;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserRequestMapper {

    // kakao
    UserCommand.KakaoRequest of(UserRequest.KakaoRequest request);

    // naver
    UserCommand.NaverRequest of(UserRequest.NaverRequest request);

}
