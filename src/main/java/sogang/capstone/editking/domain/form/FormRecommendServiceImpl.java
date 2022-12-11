package sogang.capstone.editking.domain.form;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sogang.capstone.editking.domain.form.FormCommand.AnalyzeSynonymRequest;

@Service
@RequiredArgsConstructor
public class FormRecommendServiceImpl implements FormRecommendService {

    private final FormReader formReader;
    private final FormInfoMapper formInfoMapper;

    @Override
    public FormInfo.SynonymMain recommendSynonym(String word) {
        FormCommand.AnalyzeSynonymRequest analyzeSynonymRequest = new AnalyzeSynonymRequest(word);

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

        HttpEntity<FormCommand.AnalyzeSynonymRequest> entity = new HttpEntity<>(analyzeSynonymRequest, headers);

        ResponseEntity<FormInfo.AnalyzedSynonym> analyzedResult = restTemplate.exchange(
                "http://172.31.5.238:5001/w2v/inference",
                org.springframework.http.HttpMethod.POST,
                entity,
                FormInfo.AnalyzedSynonym.class
        );

        List<String> synonymList = analyzedResult.getBody().getResult();

        return formInfoMapper.of(word, synonymList);
    }
}
