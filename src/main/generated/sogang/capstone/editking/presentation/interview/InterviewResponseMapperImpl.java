package sogang.capstone.editking.presentation.interview;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.interview.InterviewInfo.InterviewQuestion;
import sogang.capstone.editking.presentation.interview.InterviewResponse.InterviewMain;
import sogang.capstone.editking.presentation.interview.InterviewResponse.InterviewQuestion.InterviewQuestionBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-11T19:11:54+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class InterviewResponseMapperImpl implements InterviewResponseMapper {

    @Override
    public InterviewMain of(sogang.capstone.editking.domain.interview.InterviewInfo.InterviewMain mainResult) {
        if ( mainResult == null ) {
            return null;
        }

        InterviewMain interviewMain = new InterviewMain();

        interviewMain.setInterviewList( interviewQuestionListToInterviewQuestionList( mainResult.getInterviewList() ) );

        return interviewMain;
    }

    protected sogang.capstone.editking.presentation.interview.InterviewResponse.InterviewQuestion interviewQuestionToInterviewQuestion(InterviewQuestion interviewQuestion) {
        if ( interviewQuestion == null ) {
            return null;
        }

        InterviewQuestionBuilder interviewQuestion1 = sogang.capstone.editking.presentation.interview.InterviewResponse.InterviewQuestion.builder();

        interviewQuestion1.category( interviewQuestion.getCategory() );
        interviewQuestion1.content( interviewQuestion.getContent() );

        return interviewQuestion1.build();
    }

    protected List<sogang.capstone.editking.presentation.interview.InterviewResponse.InterviewQuestion> interviewQuestionListToInterviewQuestionList(List<InterviewQuestion> list) {
        if ( list == null ) {
            return null;
        }

        List<sogang.capstone.editking.presentation.interview.InterviewResponse.InterviewQuestion> list1 = new ArrayList<sogang.capstone.editking.presentation.interview.InterviewResponse.InterviewQuestion>( list.size() );
        for ( InterviewQuestion interviewQuestion : list ) {
            list1.add( interviewQuestionToInterviewQuestion( interviewQuestion ) );
        }

        return list1;
    }
}
