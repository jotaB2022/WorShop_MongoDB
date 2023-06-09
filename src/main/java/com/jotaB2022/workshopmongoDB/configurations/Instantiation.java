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
import com.jotaB2022.workshopmongoDB.dto.CommentDTO;
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
		
		CommentDTO c1 = new CommentDTO("Boa Viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Bora que bora!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c3 = new CommentDTO("Paisagem bunita!", sdf.parse("21/03/2018"), new AuthorDTO(alex));

		post1.getCommentDTO().addAll(Arrays.asList(c1,c2));
		post2.getCommentDTO().addAll(Arrays.asList(c3));
		
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		repository.save(maria);
		

		
		
	}

}
