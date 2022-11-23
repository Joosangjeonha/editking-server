package sogang.capstone.editking.form.domain;

import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public interface FormRepository {

    public Form findById(Long id);

    public void save(Form form);

    public void delete(Form form);

    public List<Form> findAll(Specification<Form> spec, int maxResults);
}
