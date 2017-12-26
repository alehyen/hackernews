package com.hackernews.post;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Post {

	@Id
	private String id;
	private String title;
	private String body;
	private Date createdAt;
	private String writerId;
	private List<Comment> comments;
	
	public Post() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getWriter() {
		return writerId;
	}

	public void setWriter(String writer) {
		this.writerId = writer;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
