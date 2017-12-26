package com.hackernews.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class UserService {

	@Autowired
	private UserRepository  userrepository;
	
	public void addUser(User user) {
		this.userrepository.save(user);
	}
}
