package com.jeonpeace.memo.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeonpeace.memo.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

	// ORDER BY `id` DESC
	public List<Post> findAllByUserIdOrderByIdDesc(int userId);
	
}
