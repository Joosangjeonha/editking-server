package sogang.capstone.editking.application.form;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.domain.form.FormInfo;
import sogang.capstone.editking.domain.form.FormRecommendService;

@Service
@RequiredArgsConstructor
public class FormRecommendFacade {

    private final FormRecommendService formRecommendService;

    public FormInfo.SynonymMain recommendSynonym(String word) {
        return formRecommendService.recommendSynonym(word);
    }
}
