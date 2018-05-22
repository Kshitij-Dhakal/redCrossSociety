package com.example.dhaka.redcrosssociety.model;

public class person {
    private int id;
    private String fname;
    private String lname;
    private String gender;
    private String address;
    private String contact;
    private String blood_group;
    public static final int ID = 0;
    public static final int FNAME = 1;
    public static final int LNAME = 2;
    public static final int GENDER = 3;
    public static final int ADDRESS = 4;
    public static final int CONTACT = 5;
    public static final int BLOOD_GROUP = 6;
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FNAME = "fname";
    public static final String COLUMN_LNAME = "lname";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_CONTACT = "contact";
    public static final String COLUMN_BLOOD_GROUP = "blood_group";

    public person(int id, String fname, String lname, String gender, String address, String contact, String blood_group) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.address = address;
        this.contact = contact;
        this.blood_group = blood_group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }
}
