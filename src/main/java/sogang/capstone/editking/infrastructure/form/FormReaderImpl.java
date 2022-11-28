package sogang.capstone.editking.infrastructure.form;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.common.exception.EntityNotFoundException;
import sogang.capstone.editking.domain.form.Form;
import sogang.capstone.editking.domain.form.FormReader;
import sogang.capstone.editking.domain.form.FormRepository;

@Component
@RequiredArgsConstructor
public class FormReaderImpl implements FormReader {

    private final FormRepository formRepository;

    @Override
    public Form getForm(Long id) {
        return formRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
