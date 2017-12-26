package com.hackernews.user;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class UserService {

	@Autowired
	private UserRepository  userrepository;
	
	public void addUser(User user) {
		String hashedpassword = DigestUtils.sha256Hex(user.getPassword());
		user.setPassword(hashedpassword);
		this.userrepository.save(user);
	}

	public User getUser(String id) {
		return this.userrepository.findOne(id);
	}
}
