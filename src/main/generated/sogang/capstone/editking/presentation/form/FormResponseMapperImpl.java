package sogang.capstone.editking.presentation.form;

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
import sogang.capstone.editking.domain.form.FormInfo.CatalogMain;
import sogang.capstone.editking.domain.form.FormInfo.Main;
import sogang.capstone.editking.presentation.form.FormResponse.CatalogForm;
import sogang.capstone.editking.presentation.form.FormResponse.Question;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-29T18:35:44+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class FormResponseMapperImpl implements FormResponseMapper {

    private final DatatypeFactory datatypeFactory;

    public FormResponseMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public sogang.capstone.editking.presentation.form.FormResponse.Main of(Main mainResult) {
        if ( mainResult == null ) {
            return null;
        }

        sogang.capstone.editking.presentation.form.FormResponse.Main main = new sogang.capstone.editking.presentation.form.FormResponse.Main();

        main.setDueDate( xmlGregorianCalendarToString( dateToXmlGregorianCalendar( mainResult.getDueDate() ), "yyyy-MM-dd HH:mm:ss" ) );
        main.setId( mainResult.getId() );
        main.setCompany( mainResult.getCompany() );
        main.setTitle( mainResult.getTitle() );
        main.setQuestionList( questionListToQuestionList( mainResult.getQuestionList() ) );

        return main;
    }

    @Override
    public sogang.capstone.editking.presentation.form.FormResponse.CatalogMain of(CatalogMain mainResult) {
        if ( mainResult == null ) {
            return null;
        }

        sogang.capstone.editking.presentation.form.FormResponse.CatalogMain catalogMain = new sogang.capstone.editking.presentation.form.FormResponse.CatalogMain();

        catalogMain.setFormList( catalogFormListToCatalogFormList( mainResult.getFormList() ) );

        return catalogMain;
    }

    @Override
    public CatalogForm of(sogang.capstone.editking.domain.form.FormInfo.CatalogForm formList) {
        if ( formList == null ) {
            return null;
        }

        CatalogForm catalogForm = new CatalogForm();

        catalogForm.setDueDate( xmlGregorianCalendarToString( dateToXmlGregorianCalendar( formList.getDueDate() ), "yyyy-MM-dd HH:mm:ss" ) );
        catalogForm.setId( formList.getId() );
        catalogForm.setCompany( formList.getCompany() );
        catalogForm.setTitle( formList.getTitle() );

        return catalogForm;
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

    protected List<CatalogForm> catalogFormListToCatalogFormList(List<sogang.capstone.editking.domain.form.FormInfo.CatalogForm> list) {
        if ( list == null ) {
            return null;
        }

        List<CatalogForm> list1 = new ArrayList<CatalogForm>( list.size() );
        for ( sogang.capstone.editking.domain.form.FormInfo.CatalogForm catalogForm : list ) {
            list1.add( of( catalogForm ) );
        }

        return list1;
    }
}
