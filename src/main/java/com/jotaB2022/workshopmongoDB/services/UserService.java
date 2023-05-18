package com.jotaB2022.workshopmongoDB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotaB2022.workshopmongoDB.domain.User;
import com.jotaB2022.workshopmongoDB.dto.UserDTO;
import com.jotaB2022.workshopmongoDB.repositories.UserRepository;
import com.jotaB2022.workshopmongoDB.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User fromDTO(UserDTO objDto) {
		User user = new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		return user;
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		}

	private void updateData(User entity, User obj) {

		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());

}
}
/*
 * public User findById(String id) { Optional <User> user = repo.findById(id);
 * if (user == null) { throw new
 * ObjectNotFoundException("Objeto não encontrado"); } return user.get(); }
 */
