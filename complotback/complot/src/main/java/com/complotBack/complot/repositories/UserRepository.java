package com.complotBack.complot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.complotBack.complot.models.UserApp;

@Repository
public interface UserRepository extends JpaRepository<UserApp, Long> {

	public Optional<UserApp> findByLogin(String login);
	
}
