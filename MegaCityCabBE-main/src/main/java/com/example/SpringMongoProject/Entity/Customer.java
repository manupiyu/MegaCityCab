package com.example.SpringMongoProject.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patient")
@Data
public class Customer {
    @Id
    private String _id;
    private String name;
    private String address;
    private String nic;
    private String contact;
    private String email;
    private String doctor;
    private boolean payment;
}
