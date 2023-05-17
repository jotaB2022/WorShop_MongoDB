package com.jotaB2022.workshopmongoDB.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotaB2022.workshopmongoDB.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
/*
 * return in function with All User Attribute
 * */
	@GetMapping
	public List<User> findAll(){
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex green", "alex@gmail.com");
		User george = new User("3", "George Baptist", "george@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex,george));
		return list;
	}
	
}
