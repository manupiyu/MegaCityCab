package com.example.SpringMongoProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerRegisterDto {
    private String name;
    private String contact;
    private String address;
    private String nic;
    private String doctor;
    private String email;
}
