package com.example.SpringMongoProject.Service;

import com.example.SpringMongoProject.Entity.User;
import com.example.SpringMongoProject.Repo.UserRepo;
import com.example.SpringMongoProject.dto.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User userRegistration(UserRegisterDto userRegisterDto) {

        User user = new User();
        user.setName(userRegisterDto.getName());
        user.setRole(userRegisterDto.getRole());
        user.setMobile(userRegisterDto.getMobile());
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(userRegisterDto.getPassword());
        return userRepo.save(user);
    }
}
