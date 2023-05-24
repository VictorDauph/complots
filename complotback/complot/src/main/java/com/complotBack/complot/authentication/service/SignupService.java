package com.complotBack.complot.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.complotBack.complot.models.UserApp;
import com.complotBack.complot.repositories.UserRepository;

@Service
public class SignupService {
	
	@Autowired
	UserRepository userRepository;

	public void signupUser(UserApp userToSignup) {
		//Créer de contrôles pour les emails et password.
		 userRepository.save(userToSignup);
	}
}
