package sogang.capstone.editking.form.domain;

import org.springframework.data.jpa.domain.Specification;

public class FormCatalogSpec {

    public static Specification<Form> user(Long userId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("user").get("id"), userId);
    }

    public static Specification<Form> status(String status) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), FormStatus.valueOf(status));
    }

}
