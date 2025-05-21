package com.elderwood.restapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.elderwood.restapi.model.user;
import com.elderwood.restapi.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;
    
     public CustomUserDetailService(UserRepository ur){
        this.userRepository = ur;
     }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user user = userRepository.findByUsername(username)
                            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));;
        
                return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER") // Assign user roles
                .build();
    }
}
