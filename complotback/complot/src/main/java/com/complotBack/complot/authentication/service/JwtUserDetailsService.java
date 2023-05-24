package com.complotBack.complot.authentication.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.complotBack.complot.authentication.dto.JwtUserDetails;
import com.complotBack.complot.authentication.enums.Roles;
import com.complotBack.complot.models.UserApp;
import com.complotBack.complot.repositories.UserRepository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class JwtUserDetailsService{

    public static final String USER = "USER";
    public static final String ROLE_USER = "ROLE_" + USER;

    // ...
    @Autowired
    private UserRepository userRepository;

    public JwtUserDetails loadUserByUsername(final String username) {
        final UserApp user = userRepository.findByLogin(username).orElseThrow(
                ()->new UsernameNotFoundException("User " + username + " not found")); 
        
        return new JwtUserDetails(user.getId(), username, user.getLogin(), user.getEncryptedPassword());
    }

}