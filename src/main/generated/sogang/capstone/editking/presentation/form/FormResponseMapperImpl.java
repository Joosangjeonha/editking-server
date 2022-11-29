package sogang.capstone.editking.presentation.form;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.form.FormInfo.Main;
import sogang.capstone.editking.presentation.form.FormResponse.Question;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-29T17:05:33+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class FormResponseMapperImpl implements FormResponseMapper {

    @Override
    public sogang.capstone.editking.presentation.form.FormResponse.Main of(Main mainResult) {
        if ( mainResult == null ) {
            return null;
        }

        sogang.capstone.editking.presentation.form.FormResponse.Main main = new sogang.capstone.editking.presentation.form.FormResponse.Main();

        main.setDueDate( mainResult.getDueDate() );
        main.setId( mainResult.getId() );
        main.setCompany( mainResult.getCompany() );
        main.setTitle( mainResult.getTitle() );
        main.setQuestionList( questionListToQuestionList( mainResult.getQuestionList() ) );

        return main;
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
}
