package com.hackernews.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackernews.user.CustomUserDetails;

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
	
	@RequestMapping("/posts/{id}")
	public Post getPost(@PathVariable String id) {
		return this.postservice.getPost(id);
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
	@ResponseBody
	public String deletePosts(@PathVariable String id, Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		Post post = this.postservice.getPost(id);
		if(post.getAuthor().equals(userDetails.getId())) {
			this.postservice.deletePost(id);
			return "OK";
		}
		return "You don't have the right to delete this post";
		
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/posts/{id}/comments")
	public void addComment(@PathVariable String id , @RequestBody Comment comment) {
		this.postservice.addComment(id, comment);
		
	}
	
	
	

}
