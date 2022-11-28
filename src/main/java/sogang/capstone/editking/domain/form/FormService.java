package sogang.capstone.editking.domain.form;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogang.capstone.editking.common.exception.ForbiddenException;
import sogang.capstone.editking.common.util.TimestampParser;
import sogang.capstone.editking.domain.user.User;
import sogang.capstone.editking.presentation.form.dto.FormDTO;
import sogang.capstone.editking.presentation.form.request.EditFormRequest;
import sogang.capstone.editking.presentation.form.request.NewFormRequest;
import sogang.capstone.editking.presentation.form.request.UpdateQuestionRequest;

@Service
@RequiredArgsConstructor
public class FormService {

    private final FormRepository formRepository;

    @Transactional
    public FormDTO createFormWithNewFormRequest(User user, NewFormRequest newFormRequest) {
        TimestampParser timestampParser = new TimestampParser();
        Timestamp dueDate = timestampParser.stringToTimestamp(newFormRequest.getDueDate());

        List<Question> questionList = newFormRequest.getQuestionList().stream().map(Question::new)
                .collect(Collectors.toList());

        Form newForm = Form.builder()
                .title(newFormRequest.getTitle())
                .dueDate(dueDate)
                .user(user)
                .company(newFormRequest.getCompany())
                .questionList(questionList)
                .build();
        formRepository.save(newForm);

        return new FormDTO(newForm);
    }

    @Transactional(readOnly = true)
    private Form validateWriterOfForm(User user, Long formId) {
        Form form = formRepository.findById(formId);
        if (form.getUser().getId() != user.getId()) {
            throw new ForbiddenException("해당 폼을 작성한 유저가 아닙니다.");
        }
        return form;
    }

    @Transactional
    public void deleteForm(User user, Long formId) {
        Form form = validateWriterOfForm(user, formId);
        formRepository.delete(form);
    }

    @Transactional(readOnly = true)
    public FormDTO readFormDetail(User user, Long formId) {
        Form form = validateWriterOfForm(user, formId);
        return new FormDTO(form);
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
