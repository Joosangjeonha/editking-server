package sogang.capstone.editking.presentation.form;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sogang.capstone.editking.domain.form.FormCommand;
import sogang.capstone.editking.domain.user.User;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface FormDtoMapper {

    FormCommand.RegisterForm of(FormDto.RegisterFormRequest request, User user);

}
