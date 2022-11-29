package sogang.capstone.editking.infrastructure.form;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sogang.capstone.editking.domain.form.Form;
import sogang.capstone.editking.domain.form.FormStatus;
import sogang.capstone.editking.domain.user.User;

public interface FormRepository extends JpaRepository<Form, Long> {

    public Optional<Form> findById(Long id);

    public Form save(Form form);

    public void delete(Form form);

    public List<Form> findByUserAndStatusOrderByDueDateAsc(User user, FormStatus status);
}
