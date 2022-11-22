package sogang.capstone.editking.form.application;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogang.capstone.editking.form.application.dto.FormDTO;
import sogang.capstone.editking.form.application.request.NewFormRequest;
import sogang.capstone.editking.form.domain.Form;
import sogang.capstone.editking.form.domain.FormRepository;
import sogang.capstone.editking.form.domain.Question;
import sogang.capstone.editking.global.exception.ForbiddenException;
import sogang.capstone.editking.global.util.TimestampParser;
import sogang.capstone.editking.user.domain.User;

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

        return new FormDTO(newForm, questionList);
    }

    @Transactional(readOnly = true)
    public FormDTO validateWriterOfForm(User user, Long formId) {
        Form form = formRepository.findById(formId);
        if (form.getUser().getId() != user.getId()) {
            throw new ForbiddenException("해당 폼을 작성한 유저가 아닙니다.");
        }
        return new FormDTO(form, form.getQuestionList());
    }

    @Transactional
    public void deleteForm(Long formId) {
        Form form = formRepository.findById(formId);
        formRepository.delete(form);
    }
}
