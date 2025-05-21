package com.elderwood.restapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.elderwood.restapi.model.user;
import com.elderwood.restapi.repository.UserRepository;
import com.elderwood.restapi.service.UserService;
import com.elderwood.restapi.service.tableService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class userController {

    private static final Logger logger = LoggerFactory.getLogger(userController.class);
        
    @SuppressWarnings("unused")
    private UserRepository userRepo;
    private UserService userService;

    
    public userController(UserRepository userRepository, UserService userService){
            this.userRepo = userRepository;
            this.userService = userService;
    }

    @PostMapping("/register/user")
    public ResponseEntity<?> registerUser(@RequestBody user user){
        System.out.println(user.getUsername() + " " + user.getPassword());
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(user.getUsername(), user.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body(e);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Object> postMethodName(@RequestHeader("Authorization")  String header) {
        logger.info(header);
        String json = "{token:active}"; 
        return new ResponseEntity<Object>(json, HttpStatus.OK);
    }

    @PostMapping("/auth")
    public String postJWTAuth(@RequestBody String entity) {
        //TODO: process POST request
        return entity;
    }
    
    
}
