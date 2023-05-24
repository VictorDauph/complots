package com.complotBack.complot.models;




import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.complotBack.complot.authentication.dto.SignupRequest;
import com.complotBack.complot.authentication.enums.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name="USERS")
@Getter
public class UserApp{
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    //nom affiché
    @Column(name="USERNAME", length=50, nullable=false, unique=true)
    private String username;
    
    //addresse email
    @Column(name="LOGIN", length=50, nullable=false, unique=true)
    private String login;
    
    @Column(name="ENC_PWD", nullable=false, unique=false)
    private String encryptedPassword;
    
    //to create a new user and encrypt its password
    public UserApp(SignupRequest signupRequest){
    	this.username= signupRequest.getUsername();
    	this.login= signupRequest.getLogin();
    	this.encryptedPassword= this.passwordEncoder().encode(signupRequest.getPassword());
    }
    
    //to fill UserDetails
    public UserApp(String username,String login, String hash){
    	this.username= getUsername();
    	this.login= getLogin();
    	this.encryptedPassword= hash;
    }
}
