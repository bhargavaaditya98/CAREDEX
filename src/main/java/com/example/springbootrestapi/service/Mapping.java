package com.example.springbootrestapi.service;

import com.example.springbootrestapi.bean.Facility1Data;
import com.example.springbootrestapi.bean.Patient;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Mapping {
    public List<Patient> mapFacilityDataToPatientData(List<Facility1Data> facilityDataList) {
        List<Patient> patientList = new ArrayList<>();
        for (Facility1Data facilityData : facilityDataList) {
            Patient patient = new Patient();
            patient.setName(facilityData.getPatientName());
            patient.setGender(facilityData.getGender());
            patient.setSpecial_needs(facilityData.getSpecialNeeds());
            patient.setIllness(facilityData.getSpecificIllness());
            patient.setFacility(facilityData.getFacilityId());

            LocalDate dob = LocalDate.parse(facilityData.getDob());
            LocalDate now = LocalDate.now();
            Period age = Period.between(dob, now);
            patient.setAge(age.getYears());

            patientList.add(patient);
        }
        return patientList;
    }
}
