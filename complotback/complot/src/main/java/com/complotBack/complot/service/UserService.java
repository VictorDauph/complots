package com.complotBack.complot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.complotBack.complot.dto.UserDto;
import com.complotBack.complot.entityService.UserEntityService;
import com.complotBack.complot.models.User;

@Service
public class UserService {
	
	@Autowired
	UserEntityService userEntityService;
	
	public void createUser(User user) throws Exception {
		if(user.getId()!=null) {
			throw new Exception("l'Id doit être null");
		}else if(user.getUsername()==null){
			throw new Exception("l'username doit être renseigné");
		}else {
			userEntityService.createUser(user);
		}
	}
	
	public long logUser(UserDto dto) {
		
		return userEntityService.logUser(dto.getUsername());
	}
}
