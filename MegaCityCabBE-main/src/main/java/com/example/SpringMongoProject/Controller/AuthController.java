package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Entity.User;
import com.example.SpringMongoProject.Service.AuthServicen;
import com.example.SpringMongoProject.dto.UserCredentialsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/auth")
public class AuthController {

    @Autowired
    private AuthServicen authService;

    @PostMapping(value = "/login")
    private Optional<User> userLogin(@RequestBody UserCredentialsDto userCredentialsDto) throws Exception {
        try {
            return authService.userLogin(userCredentialsDto.getEmail(), userCredentialsDto.getPassword());
        } catch (Exception e) {
            throw new Exception("Some exception " + e);
        }
    }

}
