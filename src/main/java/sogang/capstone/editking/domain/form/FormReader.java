package sogang.capstone.editking.domain.form;

import java.util.List;
import sogang.capstone.editking.domain.user.User;

public interface FormReader {

    Form getForm(Long id);

    List<Form> getFormCatalog(User user, FormStatus status, Integer limit);
}
