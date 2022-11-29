package sogang.capstone.editking.presentation.form;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.form.FormCommand.EditForm;
import sogang.capstone.editking.domain.form.FormCommand.EditForm.EditFormBuilder;
import sogang.capstone.editking.domain.form.FormCommand.EditQuestion;
import sogang.capstone.editking.domain.form.FormCommand.EditQuestion.EditQuestionBuilder;
import sogang.capstone.editking.domain.form.FormCommand.RegisterForm;
import sogang.capstone.editking.domain.form.FormCommand.RegisterForm.RegisterFormBuilder;
import sogang.capstone.editking.domain.form.FormCommand.UpdateQuestionRequest.UpdateQuestionRequestBuilder;
import sogang.capstone.editking.domain.form.FormInfo.Main;
import sogang.capstone.editking.presentation.form.FormDto.EditFormRequest;
import sogang.capstone.editking.presentation.form.FormDto.EditQuestionRequest;
import sogang.capstone.editking.presentation.form.FormDto.Question;
import sogang.capstone.editking.presentation.form.FormDto.RegisterFormRequest;
import sogang.capstone.editking.presentation.form.FormDto.RegisterQuestionRequest;
import sogang.capstone.editking.presentation.form.FormDto.UpdateQuestionRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-29T16:35:38+0900",
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
        main.setQuestionList( questionListToQuestionList( mainResult.getQuestionList() ) );

        return main;
    }

    @Override
    public RegisterForm of(RegisterFormRequest request) {
        if ( request == null ) {
            return null;
        }

        RegisterFormBuilder registerForm = RegisterForm.builder();

        registerForm.company( request.getCompany() );
        registerForm.title( request.getTitle() );
        registerForm.dueDate( request.getDueDate() );
        List<RegisterQuestionRequest> list = request.getQuestionList();
        if ( list != null ) {
            registerForm.questionList( new ArrayList<RegisterQuestionRequest>( list ) );
        }

        return registerForm.build();
    }

    @Override
    public EditForm of(EditFormRequest request) {
        if ( request == null ) {
            return null;
        }

        EditFormBuilder editForm = EditForm.builder();

        editForm.questionList( editQuestionRequestListToEditQuestionList( request.getQuestionList() ) );
        editForm.company( request.getCompany() );
        editForm.title( request.getTitle() );
        editForm.dueDate( request.getDueDate() );

        return editForm.build();
    }

    @Override
    public EditQuestion of(EditQuestionRequest request) {
        if ( request == null ) {
            return null;
        }

        EditQuestionBuilder editQuestion = EditQuestion.builder();

        editQuestion.idx( request.getIdx() );
        editQuestion.title( request.getTitle() );
        editQuestion.maximum( request.getMaximum() );
        editQuestion.content( request.getContent() );

        return editQuestion.build();
    }

    @Override
    public sogang.capstone.editking.domain.form.FormCommand.UpdateQuestionRequest of(UpdateQuestionRequest request) {
        if ( request == null ) {
            return null;
        }

        UpdateQuestionRequestBuilder updateQuestionRequest = sogang.capstone.editking.domain.form.FormCommand.UpdateQuestionRequest.builder();

        updateQuestionRequest.content( request.getContent() );
        updateQuestionRequest.formStatus( request.getFormStatus() );

        return updateQuestionRequest.build();
    }

    protected Question questionToQuestion(sogang.capstone.editking.domain.form.FormInfo.Question question) {
        if ( question == null ) {
            return null;
        }

        Question question1 = new Question();

        question1.setIdx( question.getIdx() );
        question1.setTitle( question.getTitle() );
        question1.setMaximum( question.getMaximum() );
        question1.setContent( question.getContent() );

        return question1;
    }

    protected List<Question> questionListToQuestionList(List<sogang.capstone.editking.domain.form.FormInfo.Question> list) {
        if ( list == null ) {
            return null;
        }

        List<Question> list1 = new ArrayList<Question>( list.size() );
        for ( sogang.capstone.editking.domain.form.FormInfo.Question question : list ) {
            list1.add( questionToQuestion( question ) );
        }

        return list1;
    }

    protected List<EditQuestion> editQuestionRequestListToEditQuestionList(List<EditQuestionRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<EditQuestion> list1 = new ArrayList<EditQuestion>( list.size() );
        for ( EditQuestionRequest editQuestionRequest : list ) {
            list1.add( of( editQuestionRequest ) );
        }

        return list1;
    }
}
