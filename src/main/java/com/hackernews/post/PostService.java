package com.hackernews.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.jayway.jsonpath.Criteria;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postrepository;
	
	@Autowired
	private MongoOperations mongo;
	
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
	
	public void addComment(String id, Comment comment) {
		Post post = mongo.findOne(new Query((CriteriaDefinition) Criteria.where("id").is(id)), Post.class);
		if(post!=null) {
			post.getComments().add(comment);
			mongo.save(post);
		}
	}

}
