package sogang.capstone.editking.common.specification;

import java.util.Arrays;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AndSpecification<T> implements Specification<T> {

    private List<Specification<T>> specs;

    public AndSpecification(Specification<T>... specs) {
        this.specs = Arrays.asList(specs);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate[] predicates = specs.stream()
                .map(spec -> spec.toPredicate(root, query, criteriaBuilder))
                .toArray(size -> new Predicate[size]);
        return criteriaBuilder.and(predicates);
    }
}