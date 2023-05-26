package com.complotBack.complot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.complotBack.complot.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT id FROM User u WHERE u.username= :username ")
	public Optional<Long> getIdByUsername(@Param("username") String username);

}
