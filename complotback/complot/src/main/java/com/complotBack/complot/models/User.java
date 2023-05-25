package com.complotBack.complot.models;

import com.complotBack.complot.dto.UserCreationDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USERS")
@Data
@NoArgsConstructor
public class User {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="USERNAME", length=50, nullable=false, unique=true)
    private String username;
    
    public User(UserCreationDto userCreationDto){
    	this.username = userCreationDto.getUsername();
    }
    /*
    @Column(name="ENC_PWD", nullable=false, unique=false)
    private String encryptedPassword;
    */
}
