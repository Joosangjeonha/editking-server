package sogang.capstone.editking.domain.form;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.domain.form.interview.Interview;

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
    public FormInfo.InterviewMain recommendInterview(Form form) {
        // TODO: Mock Data
        List<Interview> recommendedList = new ArrayList<>();
        Interview interview1 = Interview.builder()
                .category("COOPERATION")
                .content("동아리 협업할 때 힘들었던 점은?")
                .form(form)
                .build();
        Interview interview2 = Interview.builder()
                .category("JOB")
                .content("인턴하면서 힘들었던 점은?")
                .form(form)
                .build();
        recommendedList.add(interview1);
        recommendedList.add(interview2);

        List<FormInfo.InterviewQuestion> interviewList = recommendedList.stream().map(FormInfo.InterviewQuestion::new)
                .collect(Collectors.toList());
        return new FormInfo.InterviewMain(interviewList);
    }
}
