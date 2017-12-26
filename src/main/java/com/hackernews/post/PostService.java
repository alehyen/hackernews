package com.hackernews.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postrepository;
	
	public String getAllPosts() {
		return "List of all posts";
	}
	
	public void addPost(Post post) {
		this.postrepository.save(post);
	}

}
