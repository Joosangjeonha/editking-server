package sogang.capstone.editking.form.application;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogang.capstone.editking.form.application.dto.FormCatalogDTO;
import sogang.capstone.editking.form.domain.Form;
import sogang.capstone.editking.form.domain.FormCatalogSpec;
import sogang.capstone.editking.form.domain.FormRepository;
import sogang.capstone.editking.global.common.Specs;
import sogang.capstone.editking.user.domain.User;

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
