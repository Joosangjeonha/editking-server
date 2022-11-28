package sogang.capstone.editking.domain.form;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogang.capstone.editking.common.specification.Specs;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.presentation.form.dto.FormCatalogDTO;

@Service
@RequiredArgsConstructor
public class FormCatalogService {

    private final FormRepository formRepository;

    @Transactional(readOnly = true)
    public List<FormCatalogDTO> readFormCatalog(User user, String status, Integer limit) {
        Specification<Form> formCatalogSpec = Specs.and(FormCatalogSpec.user(user.getId()),
                FormCatalogSpec.status(status));

        List<Form> formList = formRepository.findAll(formCatalogSpec, limit);
        return formList.stream().map(FormCatalogDTO::new).collect(Collectors.toList());
    }
}
