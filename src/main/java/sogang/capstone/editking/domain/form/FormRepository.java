package sogang.capstone.editking.domain.form;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {

    public Optional<Form> findById(Long id);

    public Form save(Form form);

    public void delete(Form form);
}
