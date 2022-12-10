package sogang.capstone.editking.infrastructure.interview;

import org.springframework.data.jpa.repository.JpaRepository;
import sogang.capstone.editking.domain.interview.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

}
