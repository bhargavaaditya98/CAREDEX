package com.example.springbootrestapi.bean;

import java.util.Date;

public class FacilityData {
    private int pid;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String hasPet;
    private String photo;
    private String isAmbulatory;
    private String isAbleToCommunicate;
    private String medicalInformation;
    private String isFallRisk;
    private String isWanderRisk;
    private String isElopementRisk;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHasPet() {
        return hasPet;
    }

    public void setHasPet(String hasPet) {
        this.hasPet = hasPet;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIsAmbulatory() {
        return isAmbulatory;
    }

    public void setIsAmbulatory(String isAmbulatory) {
        this.isAmbulatory = isAmbulatory;
    }

    public String getIsAbleToCommunicate() {
        return isAbleToCommunicate;
    }

    public void setIsAbleToCommunicate(String isAbleToCommunicate) {
        this.isAbleToCommunicate = isAbleToCommunicate;
    }

    public String getMedicalInformation() {
        return medicalInformation;
    }

    public void setMedicalInformation(String medicalInformation) {
        this.medicalInformation = medicalInformation;
    }

    public String getIsFallRisk() {
        return isFallRisk;
    }

    public void setIsFallRisk(String isFallRisk) {
        this.isFallRisk = isFallRisk;
    }

    public String getIsWanderRisk() {
        return isWanderRisk;
    }

    public void setIsWanderRisk(String isWanderRisk) {
        this.isWanderRisk = isWanderRisk;
    }

    public String getIsElopementRisk() {
        return isElopementRisk;
    }

    public void setIsElopementRisk(String isElopementRisk) {
        this.isElopementRisk = isElopementRisk;
    }
}