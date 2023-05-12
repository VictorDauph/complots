package com.complotBack.complot.models;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="USERS")
@Data
public class Users {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="USERNAME", length=50, nullable=false, unique=true)
    private String username;
    
    @Column(name="ENC_PWD", nullable=false, unique=false)
    private String encryptedPassword;
}
