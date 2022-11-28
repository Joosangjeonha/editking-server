package sogang.capstone.editking.presentation.form;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.form.FormCommand.RegisterForm;
import sogang.capstone.editking.domain.form.FormCommand.RegisterForm.RegisterFormBuilder;
import sogang.capstone.editking.domain.form.FormInfo.Main;
import sogang.capstone.editking.domain.form.FormInfo.Question;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.presentation.form.FormDto.QuestionMain;
import sogang.capstone.editking.presentation.form.FormDto.RegisterFormRequest;
import sogang.capstone.editking.presentation.form.FormDto.RegisterQuestionRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-29T01:51:39+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class FormDtoMapperImpl implements FormDtoMapper {

    @Override
    public sogang.capstone.editking.presentation.form.FormDto.Main of(Main mainResult) {
        if ( mainResult == null ) {
            return null;
        }

        sogang.capstone.editking.presentation.form.FormDto.Main main = new sogang.capstone.editking.presentation.form.FormDto.Main();

        main.setDueDate( mainResult.getDueDate() );
        main.setId( mainResult.getId() );
        main.setCompany( mainResult.getCompany() );
        main.setTitle( mainResult.getTitle() );
        main.setQuestionList( questionListToQuestionMainList( mainResult.getQuestionList() ) );

        return main;
    }

    @Override
    public RegisterForm of(RegisterFormRequest request, User user) {
        if ( request == null && user == null ) {
            return null;
        }

        RegisterFormBuilder registerForm = RegisterForm.builder();

        if ( request != null ) {
            registerForm.company( request.getCompany() );
            registerForm.title( request.getTitle() );
            registerForm.dueDate( request.getDueDate() );
            List<RegisterQuestionRequest> list = request.getQuestionList();
            if ( list != null ) {
                registerForm.questionList( new ArrayList<RegisterQuestionRequest>( list ) );
            }
        }
        if ( user != null ) {
            registerForm.user( user );
        }

        return registerForm.build();
    }

    protected QuestionMain questionToQuestionMain(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionMain questionMain = new QuestionMain();

        questionMain.setIdx( question.getIdx() );
        questionMain.setTitle( question.getTitle() );
        questionMain.setMaximum( question.getMaximum() );
        questionMain.setContent( question.getContent() );

        return questionMain;
    }

    protected List<QuestionMain> questionListToQuestionMainList(List<Question> list) {
        if ( list == null ) {
            return null;
        }

        List<QuestionMain> list1 = new ArrayList<QuestionMain>( list.size() );
        for ( Question question : list ) {
            list1.add( questionToQuestionMain( question ) );
        }

        return list1;
    }
}
