package sogang.capstone.editking.infrastructure.interview;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sogang.capstone.editking.domain.interview.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    public List<Interview> findAllByFormId(Long formId);
}
