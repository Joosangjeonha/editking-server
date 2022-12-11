package sogang.capstone.editking.domain.interview;

import java.util.List;

public interface InterviewReader {

    List<Interview> getInterviewListByFormId(Long formId);

}
