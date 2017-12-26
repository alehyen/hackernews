package com.hackernews.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postrepository;
	
	public List<Post> getAllPosts() {
		 List<Post> posts = new ArrayList<>();
		 this.postrepository.findAll()
		 .forEach(posts::add);
		 return posts;
	}
	
	public void addPost(Post post) {
		this.postrepository.save(post);
	}
	
	public void updatePost(String id,Post post) {
		this.postrepository.save(post);
		
	}
	
	public void deletePost(String id) {
		this.postrepository.delete(id);
		
	}

}
