package sogang.capstone.editking.form.application;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogang.capstone.editking.form.application.dto.FormDTO;
import sogang.capstone.editking.form.application.dto.QuestionDTO;
import sogang.capstone.editking.form.application.request.NewFormRequest;
import sogang.capstone.editking.form.domain.Form;
import sogang.capstone.editking.form.domain.FormRepository;
import sogang.capstone.editking.form.domain.Question;
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

        Form newForm = Form.builder()
                .title(newFormRequest.getTitle())
                .dueDate(dueDate)
                .user(user)
                .company(newFormRequest.getCompany())
                .build();
        formRepository.save(newForm);

        List<Question> questionList = newFormRequest.getQuestionList().stream().map(Question::new).map(question -> {
            formRepository.save(question);
            return question;
        }).collect(Collectors.toList());

        List<QuestionDTO> questionDTOList = questionList.stream().map(QuestionDTO::new).collect(
                Collectors.toList());

        return new FormDTO(newForm, questionDTOList);
    }
}
