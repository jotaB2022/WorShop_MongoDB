package com.jotaB2022.workshopmongoDB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotaB2022.workshopmongoDB.domain.User;
import com.jotaB2022.workshopmongoDB.repositories.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
	return repo.findAll();
	}
}
