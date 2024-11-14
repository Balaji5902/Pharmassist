package com.example.pharmassist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}


	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception
	{
		return security
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/register","/login").permitAll()
						.anyRequest().authenticated())
				.formLogin(Customizer.withDefaults()) //inbuilt session based authenciation mechanism used by spring security
				.build();
	}
}

// CSRF -- Cross Site Request Forgery
