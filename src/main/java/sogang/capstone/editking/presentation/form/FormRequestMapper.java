package sogang.capstone.editking.presentation.form;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import sogang.capstone.editking.domain.form.FormCommand;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface FormRequestMapper {

    // register
    FormCommand.RegisterForm of(FormRequest.RegisterFormRequest request);

    // edit
    @Mappings({@Mapping(source = "request.questionList", target = "questionList")})
    FormCommand.EditForm of(FormRequest.EditFormRequest request);

    FormCommand.EditQuestion of(FormRequest.EditQuestionRequest request);

    FormCommand.UpdateQuestionRequest of(FormRequest.UpdateQuestionRequest request);
}