package com.complotBack.complot.authentication.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
public class SignupRequest {
	
    @NotNull
    @Size(max = 50)
    private String login;
    
    @NotNull
    @Size(max = 50)
    private String username;

    //à encrypter avec Bcrypt
    @NotNull
    @Size(max = 255)
    private String password;

}
