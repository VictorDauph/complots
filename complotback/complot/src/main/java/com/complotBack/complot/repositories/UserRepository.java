package com.complotBack.complot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.complotBack.complot.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findOneByUsername(String username);

}
