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

    // main
    @Mappings({@Mapping(source = "dueDate", target = "dueDate", dateFormat = "yyyy-MM-dd HH:mm:ss")})
    FormDto.Main of(FormInfo.Main mainResult);

    // register
    FormCommand.RegisterForm of(FormDto.RegisterFormRequest request, User user);

    // edit
    @Mappings({@Mapping(source = "request.questionList", target = "questionList")})
    FormCommand.EditForm of(FormDto.EditFormRequest request, User user);

    FormCommand.EditQuestion of(FormDto.EditQuestionRequest request);
}
