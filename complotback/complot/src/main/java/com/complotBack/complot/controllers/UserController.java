package com.complotBack.complot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.complotBack.complot.dto.UserDto;
import com.complotBack.complot.models.User;
import com.complotBack.complot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(path = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> register(@RequestBody UserDto userDto){
		User newUser= new User(userDto);
		try {
			userService.createUser(newUser);
			return new ResponseEntity<String>("utilisateur : "+userDto.getUsername()+" crée", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(path="/login",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> login(@RequestBody UserDto dto){
		
		try {
			return new ResponseEntity<Long>(userService.logUser(dto), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}

}
