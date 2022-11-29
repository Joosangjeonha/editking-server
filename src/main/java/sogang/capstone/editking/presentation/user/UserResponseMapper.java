package sogang.capstone.editking.presentation.user;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.domain.user.UserInfo;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserResponseMapper {

    UserResponse.Main of(User user);

    UserResponse.Token of(UserInfo.Token token);

}
