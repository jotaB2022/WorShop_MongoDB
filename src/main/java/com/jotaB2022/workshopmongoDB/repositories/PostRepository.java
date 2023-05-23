package com.jotaB2022.workshopmongoDB.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.jotaB2022.workshopmongoDB.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	
	@Query(" { 'title': { $regex : ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	

}
