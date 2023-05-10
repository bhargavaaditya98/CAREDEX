package hca.aggreate.api.service;

import hca.aggreate.api.bean.AggregateData;
import hca.aggreate.api.bean.Resident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ResidentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${facility1.url}")
    private String facility1Url;

    @Value("${facility2.url}")
    private String facility2Url;

    @Autowired
    DataMappingService dataMappingService;

    @Autowired
    CloudInteractionService cloudInteractionService;

    public List<Resident> getAllResidentData() throws Exception{
        List<Resident> residents1 = Arrays.asList(restTemplate.getForObject(facility1Url, Resident[].class));
        List<Resident> residents2 = Arrays.asList(restTemplate.getForObject(facility2Url, Resident[].class));
        List<Resident> allResidentsList = new ArrayList<>();
        allResidentsList.addAll(residents1);
        allResidentsList.addAll(residents2);

        AggregateData data1 = dataMappingService.createAggregateDataFromFacilityData(residents1,1);
        AggregateData data2 = dataMappingService.createAggregateDataFromFacilityData(residents1,2);
        List<AggregateData> aggData = new ArrayList<>();
        aggData.add(data1);
        aggData.add(data2);

        ResponseEntity<String> resp = cloudInteractionService.sendAggregateData(aggData);
        if(resp.getStatusCode() == HttpStatus.OK){
            return allResidentsList;
        }
        else{
            throw new Exception();
        }
    }

}
