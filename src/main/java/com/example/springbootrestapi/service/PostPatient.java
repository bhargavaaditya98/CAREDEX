package com.example.springbootrestapi.service;
import com.example.springbootrestapi.bean.Patient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PostPatient {

    @PostMapping("/patientsPost")
    public List<Patient> postPatientsToCloud(List<Patient> patients) {
        RestTemplate restTemplate = new RestTemplate();
        Patient patient = restTemplate.postForObject("http://10.8.59.140:8080/patient/addPatients", "http://localhost:8080/postpatients",Patient.class);
        return (List<Patient>) patient;

    }
}
