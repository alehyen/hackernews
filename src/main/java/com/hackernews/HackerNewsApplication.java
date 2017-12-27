package com.hackernews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;


import com.hackernews.user.CustomUserDetails;

import com.hackernews.user.UserRepository;

@SpringBootApplication
public class HackerNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackerNewsApplication.class, args);
		
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {
		builder.userDetailsService(s -> new CustomUserDetails(repo.findByEmail(s)));
	}
}
