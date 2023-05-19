package com.jotaB2022.workshopmongoDB.configurations;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jotaB2022.workshopmongoDB.domain.Post;
import com.jotaB2022.workshopmongoDB.domain.User;
import com.jotaB2022.workshopmongoDB.dto.AuthorDTO;
import com.jotaB2022.workshopmongoDB.repositories.PostRepository;
import com.jotaB2022.workshopmongoDB.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
 
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		repository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		repository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/08/2018"), "Partiu viajar", "Vou viajar para São Paulo", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/05/2018"),"Bom Dia", "Bora Viajar Galera!", new AuthorDTO (maria));
		Post post3 = new Post(null, sdf.parse("23/05/2018"),"Bom Dia", "Bora Viajar Galera!", new AuthorDTO (maria));
		
		
		postRepository.saveAll(Arrays.asList(post1,post2,post3));
		

		
		
	}

}
