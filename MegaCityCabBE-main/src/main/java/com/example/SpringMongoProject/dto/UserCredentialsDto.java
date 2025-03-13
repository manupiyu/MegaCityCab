package com.example.SpringMongoProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserCredentialsDto {
    private String email;
    private String password;
}
