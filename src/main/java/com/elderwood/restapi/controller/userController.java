package com.elderwood.restapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.elderwood.restapi.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        
    private UserRepository userRepo;
    
    public userController(UserRepository userRepository){
            this.userRepo = userRepository;
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
