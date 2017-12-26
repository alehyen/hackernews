package com.hackernews.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Post> getAllPosts() {
		return this.postservice.getAllPosts();
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/posts")
	public void addPosts(@RequestBody Post post) {
		this.postservice.addPost(post);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/posts/{id}")
	public void updatePosts(@PathVariable String id, @RequestBody Post post) {
		this.postservice.updatePost(id,post);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/posts/{id}")
	public void deletePosts(@PathVariable String id) {
		this.postservice.deletePost(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/posts/{id}/comments")
	public void addComment(@PathVariable String id , @RequestBody Comment comment) {
		this.postservice.addComment(id, comment);
		
	}
	
	
	

}
