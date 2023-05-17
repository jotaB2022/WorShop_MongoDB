package com.jotaB2022.workshopmongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jotaB2022.workshopmongoDB.domain.User;


public interface UserRepository extends MongoRepository<User, String>{

	
}
