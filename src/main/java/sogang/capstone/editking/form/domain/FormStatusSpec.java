package sogang.capstone.editking.form.domain;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor
@AllArgsConstructor
public class FormStatusSpec implements Specification<Form> {

    private FormStatus formstatus;

    public FormStatusSpec(String formStatus) {
        this.formstatus = FormStatus.valueOf(formStatus);
    }

    @Override
    public javax.persistence.criteria.Predicate toPredicate(Root<Form> root, CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("status"), formstatus);
    }
}
