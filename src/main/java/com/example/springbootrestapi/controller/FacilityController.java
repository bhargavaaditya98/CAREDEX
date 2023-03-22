package com.example.springbootrestapi.controller;
import com.example.springbootrestapi.bean.Facility1Data;
import com.example.springbootrestapi.bean.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class FacilityController {

    @Autowired
    RestTemplate restTemplate;

    @PutMapping("/update")
    public String updatePatient(@RequestBody Facility1Data facilityData) {
        System.out.println("received update for patient " + facilityData.getPatientName());
        Patient patient = new Patient();
        patient.setName(facilityData.getPatientName());
        patient.setGender(facilityData.getGender());
        patient.setSpecial_needs(facilityData.getSpecialNeeds());
        patient.setIllness(facilityData.getSpecificIllness());
        patient.setFacility(facilityData.getFacilityId());
        patient.setId(facilityData.getPatientId());
        LocalDate dob = LocalDate.parse(facilityData.getDob());
        patient.setAge(Period.between(dob, LocalDate.now()).getYears());

        HttpHeaders putHeaders = new HttpHeaders();
        putHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Patient> putEntity = new HttpEntity<>(patient, putHeaders);
        ResponseEntity<String> putPatientsResponse = restTemplate.exchange("http://10.8.21.181:8080/patient/updatePatient", HttpMethod.PUT, putEntity, String.class);
        if(putPatientsResponse.getStatusCode() == HttpStatus.OK && "update successful".equalsIgnoreCase(putPatientsResponse.getBody())){
            System.out.println("SUCCESS");
            return "update successful";
        } else{
            return "update failed";
        }

    }

    @GetMapping("migratePatients")
    public String getFacility1Data() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<Facility1Data[]> facilityDataResponse = restTemplate.exchange("http://10.8.6.68:8080/getAllData", HttpMethod.GET, entity, Facility1Data[].class);
        Facility1Data[] facilityDataList = facilityDataResponse.getBody();

        List<Patient> patientsList = new ArrayList<>();
        for (Facility1Data facilityData : facilityDataList) {
            Patient patient = new Patient();
            patient.setName(facilityData.getPatientName());
            patient.setGender(facilityData.getGender());
            patient.setSpecial_needs(facilityData.getSpecialNeeds());
            patient.setIllness(facilityData.getSpecificIllness());
            patient.setFacility(facilityData.getFacilityId());
            patient.setId(facilityData.getPatientId());
            LocalDate dob = LocalDate.parse(facilityData.getDob());
            patient.setAge(Period.between(dob, LocalDate.now()).getYears());

            patientsList.add(patient);
        }

        HttpHeaders postHeaders = new HttpHeaders();
        HttpEntity<List<Patient>> postEntity = new HttpEntity<>(patientsList, postHeaders);
        ResponseEntity<String> postPatientsResponse = restTemplate.exchange("http://10.8.21.181:8080/patient/addPatients", HttpMethod.POST, postEntity, String.class);
        return postPatientsResponse.getBody();
    }


}

