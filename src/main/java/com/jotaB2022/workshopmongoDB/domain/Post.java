package com.jotaB2022.workshopmongoDB.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jotaB2022.workshopmongoDB.dto.AuthorDTO;
import com.jotaB2022.workshopmongoDB.dto.CommentDTO;

@Document
public class Post implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date data;
	private String title;
	private String body;
	
	private AuthorDTO author;
	
	private List<CommentDTO> commentDTO = new ArrayList<>();

	public Post() {}

	public Post(String id, Date data, String title, String body, AuthorDTO author) {
		
		this.id = id;
		this.data = data;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	public List<CommentDTO> getCommentDTO() {
		return commentDTO;
	}

	public void setCommentDTO(List<CommentDTO> commentDTO) {
		this.commentDTO = commentDTO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
	

	
	
}
