package hca.aggreate.api.service;
import hca.aggreate.api.bean.AggregateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CloudInteractionService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${addresidents.url}")
    private String addResidents;

    @Value("${aggdata.url}")
    private String aggDataUrl;


    public void addPatients(List<Object> resident) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<List<Object>> entity = new HttpEntity<>(resident, headers);
        restTemplate.exchange(addResidents, HttpMethod.POST, entity, String.class);
    }

    public ResponseEntity sendAggregateData(List<AggregateData> aggregateData) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<List<AggregateData>> requestEntity = new HttpEntity<>(aggregateData, headers);
        return restTemplate.exchange(aggDataUrl, HttpMethod.POST, requestEntity, String.class);
    }
}
