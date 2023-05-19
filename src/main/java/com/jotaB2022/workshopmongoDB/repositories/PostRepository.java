package com.jotaB2022.workshopmongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jotaB2022.workshopmongoDB.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
