package com.example.SpringMongoProject.dto;

import com.example.SpringMongoProject.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterDto {

    private String name;
    private String mobile;
    private String email;
    private String password;
    private UserRoleEnum role;
}
