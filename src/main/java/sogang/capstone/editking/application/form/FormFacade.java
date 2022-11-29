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

    public FormInfo.Main registerForm(User user, FormCommand.RegisterForm registerForm) {
        return formService.registerForm(user, registerForm);
    }

    public void deleteForm(User user, Long id) {
        formService.deleteForm(user, id);
    }

    public FormInfo.Main retrieveForm(User user, Long id) {
        return formService.retrieveForm(user, id);
    }

    public FormInfo.Main editForm(Long formId, User user, FormCommand.EditForm request) {
        return formService.editForm(formId, user, request);
    }

    public void updateQuestionAndFormStatus(User user, Long formId, Long questionId,
            FormCommand.UpdateQuestionRequest request) {
        formService.updateQuestionAndFormStatus(user, formId, questionId, request);
    }
}
