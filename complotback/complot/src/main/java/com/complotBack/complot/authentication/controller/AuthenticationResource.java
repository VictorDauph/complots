package com.complotBack.complot.authentication.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.complotBack.complot.authentication.dto.AuthenticationRequest;
import com.complotBack.complot.authentication.dto.AuthenticationResponse;
import com.complotBack.complot.authentication.dto.JwtUserDetails;
import com.complotBack.complot.authentication.dto.SignupRequest;
import com.complotBack.complot.authentication.service.JwtTokenService;
import com.complotBack.complot.authentication.service.JwtUserDetailsService;
import com.complotBack.complot.authentication.service.SignupService;
import com.complotBack.complot.models.UserApp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/authentication")
public class AuthenticationResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	@Autowired
	private JwtTokenService jwtTokenService;
	
	@Autowired
	private SignupService signupService;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody @Valid final AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getLogin(), authenticationRequest.getPassword()));
        } catch (final BadCredentialsException ex) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        final JwtUserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getLogin());
        final AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setAccessToken(jwtTokenService.generateToken(userDetails));
        return authenticationResponse;
    }
    
    @PostMapping(value="/signup", consumes = "application/json")
    public ResponseEntity<String> signup(@RequestBody @Valid final SignupRequest signupRequest){
    	
    	signupService.signupUser(new UserApp(signupRequest));
    	
    	return new ResponseEntity<String>("utilisateur créé :"+signupRequest.getLogin(), HttpStatus.CREATED);
    }
    
	@GetMapping(value="/test", produces="application/json")
    public ResponseEntity<String> test() {
		
    	return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
    

}