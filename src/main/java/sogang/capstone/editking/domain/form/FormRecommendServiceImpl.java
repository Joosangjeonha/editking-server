package sogang.capstone.editking.domain.form;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormRecommendServiceImpl implements FormRecommendService {

    private final FormInfoMapper formInfoMapper;

    @Override
    public FormInfo.SynonymMain recommendSynonym(String word) {
        // TODO: Mock Data
        List<String> synonymList = new ArrayList<>();
        synonymList.add("지루하다");
        synonymList.add("따분하다");
        synonymList.add("싫증나다");
        synonymList.add("식상하다");

        return formInfoMapper.of(word, synonymList);
    }
}
