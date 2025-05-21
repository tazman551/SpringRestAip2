package com.elderwood.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.elderwood.restapi.model.user;
import com.elderwood.restapi.repository.UserRepository;

@Service
public class UserService {

     private UserRepository userRepository;
     private PasswordEncoder passwordEncoder;
    
     public UserService(UserRepository ur, PasswordEncoder passwordEncoder){
        this.userRepository = ur;
        this.passwordEncoder = passwordEncoder;
     }
    
        public user createUser(String username, String password) {
            user u = new user();
            u.setUsername(username);
            u.setPassword(passwordEncoder.encode(password));
            return userRepository.save(u);
        }
}
