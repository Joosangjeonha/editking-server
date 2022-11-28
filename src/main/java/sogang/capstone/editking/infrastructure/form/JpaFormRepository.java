package sogang.capstone.editking.infrastructure.form;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import sogang.capstone.editking.domain.form.Form;
import sogang.capstone.editking.domain.form.FormRepository;

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

    @Override
    public List<Form> findAll(Specification<Form> spec, int maxResults) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Form> criteriaQuery = criteriaBuilder.createQuery(Form.class);
        Root<Form> root = criteriaQuery.from(Form.class);
        if (spec != null) {
            Predicate predicate = spec.toPredicate(root, criteriaQuery, criteriaBuilder);
            criteriaQuery.where(predicate);
        }
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("dueDate")));
        TypedQuery<Form> query = entityManager.createQuery(criteriaQuery);
        query.setFirstResult(0);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }
}
