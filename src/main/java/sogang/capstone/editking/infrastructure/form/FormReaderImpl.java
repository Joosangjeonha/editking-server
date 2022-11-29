package sogang.capstone.editking.infrastructure.form;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.common.exception.EntityNotFoundException;
import sogang.capstone.editking.domain.form.Form;
import sogang.capstone.editking.domain.form.FormReader;
import sogang.capstone.editking.domain.form.FormStatus;
import sogang.capstone.editking.domain.user.User;

@Component
@RequiredArgsConstructor
public class FormReaderImpl implements FormReader {

    private final FormRepository formRepository;

    @Override
    public Form getForm(Long id) {
        return formRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Form> getFormCatalog(User user, FormStatus status, Integer limit) {
        Pageable limitPageable = PageRequest.of(0, limit);
        return formRepository.findByUserAndStatusOrderByDueDateAsc(user, status, limitPageable);
    }
}
