package com.example.springbootrestapi.bean;

public class Patient {
    private int id;
    private String name;

    public Patient(int id, String name, String gender, int age, String special_needs, String illness, int facility) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.special_needs = special_needs;
        this.illness = illness;
        this.facility = facility;
    }

    private String gender;
    private int age;
    private String special_needs;
    private String illness;

    public Patient() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecial_needs() {
        return special_needs;
    }

    public void setSpecial_needs(String special_needs) {
        this.special_needs = special_needs;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public int getFacility() {
        return facility;
    }

    public void setFacility(int facility) {
        this.facility = facility;
    }

    private int facility;
}
