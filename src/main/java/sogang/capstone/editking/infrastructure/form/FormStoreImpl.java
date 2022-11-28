package sogang.capstone.editking.infrastructure.form;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.form.Form;
import sogang.capstone.editking.domain.form.FormRepository;
import sogang.capstone.editking.domain.form.FormStore;

@Component
@RequiredArgsConstructor
public class FormStoreImpl implements FormStore {

    private final FormRepository formRepository;

    @Override
    public Form store(Form form) {
        return formRepository.save(form);
    }
}
