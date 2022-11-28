package sogang.capstone.editking.application.form;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.domain.form.FormCommand;
import sogang.capstone.editking.domain.form.FormInfo;
import sogang.capstone.editking.domain.form.FormService;
import sogang.capstone.editking.domain.user.User;

@Service
@RequiredArgsConstructor
public class FormFacade {

    private final FormService formService;

    public FormInfo.Main registerForm(FormCommand.RegisterForm registerForm) {
        return formService.registerForm(registerForm);
    }

    public void deleteForm(User user, Long id) {
        formService.deleteForm(user, id);
    }

    public FormInfo.Main retrieveForm(User user, Long id) {
        return formService.retrieveForm(user, id);
    }
}
