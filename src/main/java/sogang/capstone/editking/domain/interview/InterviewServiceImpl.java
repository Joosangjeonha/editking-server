package sogang.capstone.editking.domain.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sogang.capstone.editking.domain.form.event.SubmittedEvent;
import sogang.capstone.editking.domain.interview.InterviewCommand.AnalyzeInterviewRequest;
import sogang.capstone.editking.domain.interview.InterviewInfo.AnalyzedInterviewQuestion;

@Service
@RequiredArgsConstructor
public class InterviewServiceImpl implements InterviewService {

    private final InterviewReader interviewReader;
    private final InterviewStore interviewStore;

    @Override
    public void analyzeInterview(SubmittedEvent event) {
        AnalyzeInterviewRequest analyzeInterviewRequest = new AnalyzeInterviewRequest(event.getQuestionList());

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(100000);
        factory.setConnectTimeout(3000);
        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(5)
                .build();
        factory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(factory);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        HttpEntity<AnalyzeInterviewRequest> entity = new HttpEntity<>(analyzeInterviewRequest, headers);

//        ResponseEntity<AnalyzedInterview> analyzedResult = restTemplate.exchange(
//                "https://???????/??????",
//                org.springframework.http.HttpMethod.POST,
//                entity,
//                AnalyzedInterview.class
//        );
//
//        List<AnalyzedInterviewQuestion> interviewQuestionList = analyzedResult.getBody().getInterviewList();

        // TODO: Mock Data
        List<AnalyzedInterviewQuestion> mockInterviewQuestionList = new ArrayList<>();
        AnalyzedInterviewQuestion interview1 = new AnalyzedInterviewQuestion("COOPERATION", "동아리 협업할 때 힘들었던 점은?");
        AnalyzedInterviewQuestion interview2 = new AnalyzedInterviewQuestion("JOB", "인턴하면서 힘들었던 점은?");
        AnalyzedInterviewQuestion interview3 = new AnalyzedInterviewQuestion("CLUB", "동아리하면서 힘들었던 점은?");
        mockInterviewQuestionList.add(interview1);
        mockInterviewQuestionList.add(interview2);
        mockInterviewQuestionList.add(interview3);

        mockInterviewQuestionList.forEach(result -> {
            Interview interview = Interview.builder().content(result.getContent()).category(result.getCategory())
                    .formId(event.getFormId().getId()).build();
            interviewStore.store(interview);
        });
    }

    @Override
    public InterviewInfo.InterviewMain recommendInterview(Long formId) {
        List<InterviewInfo.InterviewQuestion> interviewList = interviewReader.getInterviewListByFormId(formId).stream()
                .map(InterviewInfo.InterviewQuestion::new)
                .collect(Collectors.toList());
        return new InterviewInfo.InterviewMain(interviewList);
    }
}