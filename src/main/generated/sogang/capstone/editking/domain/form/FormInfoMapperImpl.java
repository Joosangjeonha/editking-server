package sogang.capstone.editking.domain.form;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.form.FormInfo.Main;
import sogang.capstone.editking.domain.form.FormInfo.Main.MainBuilder;
import sogang.capstone.editking.domain.form.FormInfo.Question.QuestionBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-29T03:04:40+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class FormInfoMapperImpl implements FormInfoMapper {

    private final DatatypeFactory datatypeFactory;

    public FormInfoMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

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
            main.dueDate( xmlGregorianCalendarToString( dateToXmlGregorianCalendar( form.getDueDate() ), null ) );
            main.questionList( questionListToQuestionList( form.getQuestionList() ) );
        }

        return main.build();
    }

    private String xmlGregorianCalendarToString( XMLGregorianCalendar xcal, String dateFormat ) {
        if ( xcal == null ) {
            return null;
        }

        if (dateFormat == null ) {
            return xcal.toString();
        }
        else {
            Date d = xcal.toGregorianCalendar().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat( dateFormat );
            return sdf.format( d );
        }
    }

    private XMLGregorianCalendar dateToXmlGregorianCalendar( Date date ) {
        if ( date == null ) {
            return null;
        }

        GregorianCalendar c = new GregorianCalendar();
        c.setTime( date );
        return datatypeFactory.newXMLGregorianCalendar( c );
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
