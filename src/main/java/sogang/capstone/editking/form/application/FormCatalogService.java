package sogang.capstone.editking.form.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogang.capstone.editking.form.application.dto.FormCatalogDTO;
import sogang.capstone.editking.form.domain.FormRepository;
import sogang.capstone.editking.user.domain.User;

@Service
@RequiredArgsConstructor
public class FormCatalogService {

    private final FormRepository formRepository;

    @Transactional(readOnly = true)
    public List<FormCatalogDTO> readFormDetail(User user, String status, Long limit) {

        return null;
    }
}
