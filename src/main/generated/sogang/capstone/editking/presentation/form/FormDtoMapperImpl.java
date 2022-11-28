package sogang.capstone.editking.presentation.form;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.form.FormCommand.MakeForm;
import sogang.capstone.editking.domain.form.FormCommand.MakeForm.MakeFormBuilder;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.presentation.form.FormDto.MakeFormRequest;
import sogang.capstone.editking.presentation.form.FormDto.MakeQuestionRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-29T00:42:26+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class FormDtoMapperImpl implements FormDtoMapper {

    @Override
    public MakeForm of(MakeFormRequest request, User user) {
        if ( request == null && user == null ) {
            return null;
        }

        MakeFormBuilder makeForm = MakeForm.builder();

        if ( request != null ) {
            makeForm.company( request.getCompany() );
            makeForm.title( request.getTitle() );
            makeForm.dueDate( request.getDueDate() );
            List<MakeQuestionRequest> list = request.getQuestionList();
            if ( list != null ) {
                makeForm.questionList( new ArrayList<MakeQuestionRequest>( list ) );
            }
        }
        if ( user != null ) {
            makeForm.user( user );
        }

        return makeForm.build();
    }
}
