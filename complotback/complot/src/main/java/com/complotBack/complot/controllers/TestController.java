package com.complotBack.complot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{

	@GetMapping(value="/test", produces="application/json")
    public ResponseEntity<String> test() {
    	return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
	
	@GetMapping(value="/test2", produces="application/json")
    public ResponseEntity<String> test2() {
    	return new ResponseEntity<>("Hello World2!", HttpStatus.OK);
    }
}