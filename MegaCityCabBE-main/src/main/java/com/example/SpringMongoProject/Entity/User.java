package com.example.SpringMongoProject.Entity;

import com.example.SpringMongoProject.UserRoleEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
public class User {
    @Id
    private String _id;
    private String name;
    private String mobile;
    private String email;
    private String password;
    private UserRoleEnum role;

}
