package sogang.capstone.editking.domain.form;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogang.capstone.editking.common.exception.ForbiddenException;
import sogang.capstone.editking.common.response.ErrorCode;
import sogang.capstone.editking.domain.form.event.SubmittedEvent;
import sogang.capstone.editking.domain.user.User;

@Service
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {

    private final FormReader formReader;
    private final FormStore formStore;
    private final FormInfoMapper formInfoMapper;
    private final ApplicationEventPublisher publisher;

    @Override
    @Transactional
    public FormInfo.Main registerForm(User user, FormCommand.RegisterForm registerForm) {
        Form form = formStore.store(registerForm.toEntity(user));
        List<Question> questionList = form.getQuestionList();
        return formInfoMapper.of(form, questionList);
    }

    @Transactional(readOnly = true)
    private Form validateWriterOfForm(User user, Long formId) {
        Form form = formReader.getForm(formId);
        if (form.getUser().getId() != user.getId()) {
            throw new ForbiddenException(ErrorCode.NOT_WRITER_OF_FORM.getMessage());
        }
        return form;
    }

    @Override
    @Transactional
    public void deleteForm(User user, Long formId) {
        Form form = validateWriterOfForm(user, formId);
        formStore.delete(form);
    }

    @Override
    @Transactional(readOnly = true)
    public FormInfo.Main retrieveForm(User user, Long formId) {
        Form form = validateWriterOfForm(user, formId);
        List<Question> questionList = form.getQuestionList();
        return formInfoMapper.of(form, questionList);
    }

    @Override
    @Transactional
    public FormInfo.Main editForm(Long formId, User user, FormCommand.EditForm editForm) {
        Form form = validateWriterOfForm(user, formId);
        form.updatePropertyWith(editForm);

        List<Question> questionList = editForm.getQuestionList().stream().map(Question::new)
                .collect(Collectors.toList());
        form.updateQuestionList(questionList);

        return formInfoMapper.of(form, questionList);
    }

    @Override
    @Transactional
    public void updateQuestionAndFormStatus(User user, Long formId, Long questionId,
            FormCommand.UpdateQuestionRequest request) {
        Form form = validateWriterOfForm(user, formId);

        List<Question> questionList = form.getQuestionList();
        questionList.stream().filter(question -> question.getIdx() == questionId).findAny()
                .ifPresent(question -> question.updateContent(request.getContent()));

        form.updateFormStatus(request.getFormStatus());
        if (form.getStatus() == FormStatus.SUBMITTED) {
            publisher.publishEvent(new SubmittedEvent(this, questionList));
        }
    }
}
