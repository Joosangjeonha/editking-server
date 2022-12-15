package sogang.capstone.editking.domain.form;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.form.FormInfo.Main;
import sogang.capstone.editking.domain.form.FormInfo.Main.MainBuilder;
import sogang.capstone.editking.domain.form.FormInfo.Question.QuestionBuilder;
import sogang.capstone.editking.domain.form.FormInfo.SynonymMain;
import sogang.capstone.editking.domain.form.FormInfo.SynonymMain.SynonymMainBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T03:39:41+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class FormInfoMapperImpl implements FormInfoMapper {

    @Override
    public Main of(Form form, List<Question> questionList) {
        if ( form == null && questionList == null ) {
            return null;
        }

        MainBuilder main = Main.builder();

        if ( form != null ) {
            main.id( form.getId() );
            main.company( form.getCompany() );
            main.title( form.getTitle() );
            main.dueDate( form.getDueDate() );
            main.questionList( questionListToQuestionList( form.getQuestionList() ) );
        }

        return main.build();
    }

    @Override
    public SynonymMain of(String word, List<String> synonymList) {
        if ( word == null && synonymList == null ) {
            return null;
        }

        SynonymMainBuilder synonymMain = SynonymMain.builder();

        if ( word != null ) {
            synonymMain.word( word );
        }
        if ( synonymList != null ) {
            List<String> list = synonymList;
            if ( list != null ) {
                synonymMain.synonymList( new ArrayList<String>( list ) );
            }
        }

        return synonymMain.build();
    }

    protected sogang.capstone.editking.domain.form.FormInfo.Question questionToQuestion(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionBuilder question1 = sogang.capstone.editking.domain.form.FormInfo.Question.builder();

        question1.idx( question.getIdx() );
        question1.title( question.getTitle() );
        question1.maximum( question.getMaximum() );
        question1.content( question.getContent() );

        return question1.build();
    }

    protected List<sogang.capstone.editking.domain.form.FormInfo.Question> questionListToQuestionList(List<Question> list) {
        if ( list == null ) {
            return null;
        }

        List<sogang.capstone.editking.domain.form.FormInfo.Question> list1 = new ArrayList<sogang.capstone.editking.domain.form.FormInfo.Question>( list.size() );
        for ( Question question : list ) {
            list1.add( questionToQuestion( question ) );
        }

        return list1;
    }
}
