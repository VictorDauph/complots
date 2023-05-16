package com.complotBack.complot.authentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.complotBack.complot.authentication.enums.Roles;
import com.complotBack.complot.authentication.service.JwtRequestFilter;

@Configuration
public class JwtSecurityConfig {

    // ...
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            final AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //security filter chain sert à déterminer les endpoints qui ont besoin d'authentification et ceux qui n'en ont pas besoin
    @Bean
    public SecurityFilterChain configure(final HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .authorizeHttpRequests((authz) -> authz
                		.requestMatchers("/swagger-ui/**").permitAll()
                		.requestMatchers("/swagger-ui.html").permitAll()
                		.requestMatchers("/swagger-resources/**").permitAll()
                		.requestMatchers("/v3/api-docs/**").permitAll()
                		.requestMatchers("/").permitAll()
                		.requestMatchers("/authenticate/").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        ).sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                	.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
                
                return http.build();                
    }

}