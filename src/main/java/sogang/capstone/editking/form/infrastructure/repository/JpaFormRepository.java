package sogang.capstone.editking.form.infrastructure.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import sogang.capstone.editking.form.domain.Form;
import sogang.capstone.editking.form.domain.FormRepository;

@Repository
public class JpaFormRepository implements FormRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Form findById(Long id) {
        return entityManager.find(Form.class, id);
    }

    @Override
    public void save(Form form) {
        entityManager.persist(form);
    }

    @Override
    public void delete(Form form) {
        entityManager.remove(form);
    }
}
