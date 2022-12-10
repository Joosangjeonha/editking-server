package sogang.capstone.editking.infrastructure.interview;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.interview.Interview;
import sogang.capstone.editking.domain.interview.InterviewReader;

@Component
@RequiredArgsConstructor
public class InterviewReaderImpl implements InterviewReader {

    private final InterviewRepository interviewRepository;

    @Override
    public List<Interview> getInterviewListByFormId(Long formId) {
        return interviewRepository.findAllByFormId(formId);
    }
}
