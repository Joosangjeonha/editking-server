package sogang.capstone.editking.form.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.form.domain.FormRepository;

@Service
@RequiredArgsConstructor
public class FormService {

    private final FormRepository formRepository;

}
