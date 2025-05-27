package com.elderwood.restapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.elderwood.restapi.model.user;
import com.elderwood.restapi.repository.UserRepository;
import com.elderwood.restapi.service.JwtService;
import com.elderwood.restapi.service.UserService;
import com.elderwood.restapi.service.tableService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
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
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    
    public userController(UserRepository userRepository, UserService userService, JwtService jwtService
            , AuthenticationManager authenticationManager) {
            this.userRepo = userRepository;
            this.userService = userService;
            this.jwtService = jwtService;
            this.authenticationManager = authenticationManager;
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

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody user user, HttpServletResponse response) throws AuthenticationException{
    String username = user.getUsername();
    String password = user.getPassword();

    System.out.println("Username: " + username);
    System.out.println("Password: " + password);

    UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(username, password);

    // This will call your UserDetailsService.loadUserByUsername internally
    Authentication authentication = authenticationManager.authenticate(authenticationToken);

    // Get UserDetails from authentication
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Generate JWT token
        String token = jwtService.generateToken(userDetails);

        // Create JSON response
        String json = "{ \"token\": \"" + token + "\" }";

        // Set the token in the response header
        response.setHeader("Authorization", "Bearer " + token);

        // Return the JSON response
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(json, HttpStatus.OK);
        logger.info("Generated JWT Token: {}", token);
        
        // Return the JSON response with the token
        return responseEntity;
    }
    
    
}
