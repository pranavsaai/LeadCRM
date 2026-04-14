package com.leadcrm.finder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "leads")
public class Lead {

    @Id
    private String id;

    private String company;
    private String industry;
    private String location;

    private int companySize;

    private List<Contact> contacts;
    private List<String> insights;

    private Signals signals;

    private int score;

    private String status; 
}