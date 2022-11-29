package sogang.capstone.editking.application.form;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.domain.form.FormCatalogService;
import sogang.capstone.editking.domain.form.FormInfo;
import sogang.capstone.editking.domain.user.User;

@Service
@RequiredArgsConstructor
public class FormCatalogFacade {

    private final FormCatalogService formCatalogService;

    public FormInfo.CatalogMain retrieveFormCatalog(User user, String status, Integer limit) {
        return formCatalogService.retrieveFormCatalog(user, status, limit);
    }
}
