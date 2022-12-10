package sogang.capstone.editking.infrastructure.interview;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.interview.Interview;
import sogang.capstone.editking.domain.interview.InterviewStore;

@Component
@RequiredArgsConstructor
public class InterviewStoreImpl implements InterviewStore {

    private final InterviewRepository interviewRepository;

    @Override
    public Interview store(Interview interview) {
        return interviewRepository.save(interview);
    }

}
