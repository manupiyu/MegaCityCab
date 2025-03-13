package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Beans.MailServiceComponent;
import com.example.SpringMongoProject.Entity.User;
import com.example.SpringMongoProject.Service.UserService;
import com.example.SpringMongoProject.dto.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/user")
public class UserController {

    @Autowired
    private MailServiceComponent mailServiceComponent;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/save")
    private User userRegistration(@RequestBody UserRegisterDto userRegDto) {
        return userService.userRegistration(userRegDto);
    }

    @PostMapping(value = "/email")
    private boolean sendEmail() {
        return this.mailServiceComponent.sendSimpleMessage("gihanchaturanga98@gmail.com", "about me", "I am Dumb");
    }
}
