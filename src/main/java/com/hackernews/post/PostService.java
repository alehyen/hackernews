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
	
	public Post getPost(String id) {
		return this.postrepository.findOne(id);
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
	
	public void addComment(String id, Comment comment) {
		Post post = this.postrepository.findOne(id);
		if(post!=null) {
			post.getComments().add(comment);
			this.postrepository.save(post);
		}
		
	}

}
