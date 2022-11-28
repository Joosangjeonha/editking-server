package sogang.capstone.editking.domain.form;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogang.capstone.editking.common.exception.ForbiddenException;
import sogang.capstone.editking.common.response.ErrorCode;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.presentation.form.dto.FormDTO;
import sogang.capstone.editking.presentation.form.request.EditFormRequest;
import sogang.capstone.editking.presentation.form.request.UpdateQuestionRequest;

@Service
@RequiredArgsConstructor
public class FormService {

    private final FormRepository formRepository;
    private final FormReader formReader;
    private final FormStore formStore;
    private final FormInfoMapper formInfoMapper;

    @Transactional
    public FormInfo.Main registerForm(FormCommand.RegisterForm registerForm) {
        Form form = formStore.store(registerForm.toEntity());
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

    @Transactional
    public void deleteForm(User user, Long formId) {
        Form form = validateWriterOfForm(user, formId);
        formStore.delete(form);
    }

    @Transactional(readOnly = true)
    public FormInfo.Main retrieveForm(User user, Long formId) {
        Form form = validateWriterOfForm(user, formId);
        List<Question> questionList = form.getQuestionList();
        return formInfoMapper.of(form, questionList);
    }

    @Transactional
    public FormDTO updateForm(User user, Long formId, EditFormRequest editFormRequest) {
        Form form = validateWriterOfForm(user, formId);
        form.updatePropertyWith(editFormRequest);

        List<Question> questionList = editFormRequest.getQuestionList().stream().map(Question::new)
                .collect(Collectors.toList());
        form.updateQuestionList(questionList);

        return new FormDTO(form);
    }

    @Transactional
    public FormDTO updateQuestion(User user, Long formId, Long questionId,
            UpdateQuestionRequest updateQuestionRequest) {
        Form form = validateWriterOfForm(user, formId);

        List<Question> questionList = form.getQuestionList();
        questionList.stream().filter(question -> question.getIdx() == questionId).findAny()
                .ifPresent(question -> {
                    question.updateContent(updateQuestionRequest.getContent());
                });

        form.updateFormStatus(updateQuestionRequest.getFormStatus());
        return new FormDTO(form);
    }
}
