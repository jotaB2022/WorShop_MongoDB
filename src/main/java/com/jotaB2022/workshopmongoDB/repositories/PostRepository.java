package com.jotaB2022.workshopmongoDB.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jotaB2022.workshopmongoDB.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContainingIgnoreCase(String text);

}
