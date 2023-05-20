package com.jotaB2022.workshopmongoDB.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotaB2022.workshopmongoDB.domain.Post;
import com.jotaB2022.workshopmongoDB.repositories.PostRepository;
import com.jotaB2022.workshopmongoDB.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}