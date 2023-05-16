package com.complotBack.complot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.complotBack.complot.models.UserApp;

public interface UserRepository extends JpaRepository<UserApp, Long> {

	public Optional<UserApp> findByLogin(String login);
}
