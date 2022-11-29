package sogang.capstone.editking.domain.form;

import sogang.capstone.editking.domain.user.User;

public interface FormCatalogService {

    public FormInfo.CatalogMain retrieveFormCatalog(User user, String status, Integer limit);
}
