package com.hackernews;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hackernews.post.PostController;
import com.hackernews.post.PostRepository;

public class PostControllerTest {

	@InjectMocks
	private PostController pc;
	
	@Mock
	private PostRepository pr;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
}
