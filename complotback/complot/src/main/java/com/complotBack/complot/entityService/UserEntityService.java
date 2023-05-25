package com.complotBack.complot.entityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.complotBack.complot.models.User;
import com.complotBack.complot.repositories.UserRepository;

@Service
public class UserEntityService {
	@Autowired
	UserRepository userRepository;
	
	public void createUser(User user) {
		userRepository.save(user);
	}
	
	public long logUser(String username) {
		
		try {
		return userRepository.findOneByUsername(username).get().getId();
		}catch (Exception e) {
			throw e;
		}
		
	}

}
