package sogang.capstone.editking.domain.form;

import sogang.capstone.editking.domain.user.User;

public interface FormService {

    public FormInfo.Main registerForm(User user, FormCommand.RegisterForm registerForm);

    public void deleteForm(User user, Long formId);

    public FormInfo.Main retrieveForm(User user, Long formId);

    public FormInfo.Main editForm(Long formId, User user, FormCommand.EditForm editForm);

    public void updateQuestionAndFormStatus(User user, Long formId, Long questionId,
            FormCommand.UpdateQuestionRequest request);
}
