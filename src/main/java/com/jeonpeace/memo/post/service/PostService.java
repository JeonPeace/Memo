package com.jeonpeace.memo.post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jeonpeace.memo.common.FileManager;
import com.jeonpeace.memo.post.domain.Post;
import com.jeonpeace.memo.post.repository.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post addPost(int userId, String title, String contents, MultipartFile file) {
		
		String urlPath = FileManager.saveFile(userId, file);
		
		Post post = Post.builder()
						.userId(userId)
						.title(title)
						.contents(contents)
						.imagePath(urlPath)
						.build();
		
		Post result = postRepository.save(post);
		
		return result;
	}
	
	public List<Post> getPostList(int userId){
		
		return postRepository.findAllByUserIdOrderByIdDesc(userId);
	}
	
	public Post getPost(int id) {
		
		Optional<Post> optionalPost = postRepository.findById(id);
		
		Post post = optionalPost.orElse(null);
		
		return post;
	}
	
	public Post updatePost(int id, String title, String contents) {
		
		Optional<Post> optionalPost = postRepository.findById(id);
		
		Post post = optionalPost.orElse(null);
		
		if(post != null) {
			Post updatePost = post.toBuilder()
				.title(title)
				.contents(contents)
				.build();
			return postRepository.save(updatePost);
		}else {
			return null;
		}
		
	}
	
	public Boolean deletePost(int id) {
		
		Optional<Post> optionalPost = postRepository.findById(id);
		
		Post post = optionalPost.orElse(null);
		
		if(post != null) {
			FileManager.removeFile(post.getImagePath());
			postRepository.delete(post);
			return true;
		}else {
			return false;
		}
	}
	
}
