package com.app.jp_back_end.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {

    private long id;
    private String name;
    private String description;
    private String address;
    private String phone;
    private String email;
    private String website;
    private String location;
    private String city;
    private String state;
    private String zip;
    private String country;
    private User companyOwner;
}
