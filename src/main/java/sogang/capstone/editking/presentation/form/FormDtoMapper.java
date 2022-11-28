package sogang.capstone.editking.presentation.form;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import sogang.capstone.editking.domain.form.FormCommand;
import sogang.capstone.editking.domain.form.FormInfo;
import sogang.capstone.editking.domain.user.User;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface FormDtoMapper {

    @Mappings({
            @Mapping(source = "dueDate", target = "dueDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    FormDto.Main of(FormInfo.Main mainResult);

    FormCommand.RegisterForm of(FormDto.RegisterFormRequest request, User user);
}
