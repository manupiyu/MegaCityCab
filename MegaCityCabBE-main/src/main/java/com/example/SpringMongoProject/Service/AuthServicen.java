package com.example.SpringMongoProject.Service;

import com.example.SpringMongoProject.Entity.User;
import com.example.SpringMongoProject.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

@Service()
public class AuthServicen {

    @Autowired
    private UserRepo userRepo;

    public Optional<User> userLogin(String email, String pwd) throws Exception {
        try {
            Optional<User> user = userRepo.findByEmail(email);
            if (user.isPresent())
                if (user.get().getPassword().equals(pwd))
                    return user;

            throw new AccountNotFoundException("Unable to find the user");

        } catch (Exception e) {
            throw new AccountNotFoundException("Unable to find the user");
        }
    }
}
