package sogang.capstone.editking.domain.form;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogang.capstone.editking.domain.user.User;

@Service
@RequiredArgsConstructor
public class FormCatalogService {

    private final FormReader formReader;

    @Transactional(readOnly = true)
    public FormInfo.CatalogMain retrieveFormCatalog(User user, String status, Long limit) {
        List<Form> formList = formReader.getFormCatalog(user, FormStatus.valueOf(status), limit);
        List<FormInfo.CatalogForm> catalogFormList = formList.stream().map(FormInfo.CatalogForm::new)
                .collect(Collectors.toList());
        return new FormInfo.CatalogMain(catalogFormList);
    }
}
