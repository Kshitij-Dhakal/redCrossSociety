package com.example.dhaka.redcrosssociety.model;

public class bloodGroup {
    private String bloodGroupString;
    private String id;

    public String getBloodGroupString() {
        return bloodGroupString;
    }

    public void setBloodGroupString(String bloodGroupString) {
        this.bloodGroupString = bloodGroupString;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public bloodGroup(String bloodGroupString, String id) {

        this.bloodGroupString = bloodGroupString;
        this.id = id;
    }
}
