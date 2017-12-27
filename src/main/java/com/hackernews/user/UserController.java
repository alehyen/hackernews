package com.hackernews.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable String id) {
		return this.userservice.getUser(id);
	}
	
	@RequestMapping("/userinfo")
	@ResponseBody
	public String getUserInfo(Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		return userDetails.getId()+"  "+ userDetails.getUsername();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public void addUser(@RequestBody User user) {
		this.userservice.addUser(user);
	}

}
