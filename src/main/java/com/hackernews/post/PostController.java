package com.hackernews.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@Autowired
	private PostService postservice;
	
	@RequestMapping("/")
	public String home() {
		return "Hello World! this is OAuth2";
	}
	
	@RequestMapping("/posts")
	public String getAllPosts() {
		return this.postservice.getAllPosts();
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/posts")
	public void addPosts(@RequestBody Post post) {
		this.postservice.addPost(post);
	}
	
	

}
