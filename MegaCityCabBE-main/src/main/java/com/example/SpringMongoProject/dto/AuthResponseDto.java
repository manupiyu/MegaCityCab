package com.example.SpringMongoProject.dto;

import com.example.SpringMongoProject.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthResponseDto {
    private String name;
    private String mobile;
    private String email;
    private String id;
    private UserRoleEnum role;
}
