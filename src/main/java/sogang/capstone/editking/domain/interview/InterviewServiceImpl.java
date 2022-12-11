package sogang.capstone.editking.domain.interview;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sogang.capstone.editking.domain.form.event.SubmittedEvent;
import sogang.capstone.editking.domain.interview.InterviewCommand.AnalyzeInterviewRequest;
import sogang.capstone.editking.domain.interview.InterviewInfo.AnalyzedInterview;

@Service
@RequiredArgsConstructor
public class InterviewServiceImpl implements InterviewService {

    private final InterviewReader interviewReader;
    private final InterviewStore interviewStore;

    @Override
    public void analyzeInterview(SubmittedEvent event) {
        InterviewCommand.AnalyzeInterviewRequest analyzeInterviewRequest = new AnalyzeInterviewRequest(
                event.getQuestionList());

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

        HttpEntity<InterviewCommand.AnalyzeInterviewRequest> entity = new HttpEntity<>(analyzeInterviewRequest,
                headers);

        ResponseEntity<InterviewInfo.AnalyzedInterview> analyzedResult = restTemplate.exchange(
                "http://172.31.13.94:5001/ner/inference",
                org.springframework.http.HttpMethod.POST,
                entity,
                AnalyzedInterview.class
        );

        List<String> interviewList = analyzedResult.getBody().getResult();

        interviewList.forEach(result -> {
            Interview interview = Interview.builder().content(result).category("JOB")
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