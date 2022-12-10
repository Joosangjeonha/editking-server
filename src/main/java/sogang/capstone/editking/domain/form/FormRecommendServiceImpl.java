package sogang.capstone.editking.domain.form;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormRecommendServiceImpl implements FormRecommendService {

    private final FormReader formReader;
    private final FormInfoMapper formInfoMapper;

    @Override
    public FormInfo.SynonymMain recommendSynonym(String word) {
        // TODO: Mock Data
        List<String> synonymList = new ArrayList<>();
        synonymList.add("반영하여");
        synonymList.add("응용하여");
        synonymList.add("도입하여");

        return formInfoMapper.of(word, synonymList);
    }

    @Override
    public FormInfo.InterviewMain recommendInterview(Long id) {
        Form form = formReader.getForm(id);
        List<FormInfo.InterviewQuestion> interviewList = form.getInterviewList().stream()
                .map(FormInfo.InterviewQuestion::new)
                .collect(Collectors.toList());
        return new FormInfo.InterviewMain(interviewList);
    }
}
