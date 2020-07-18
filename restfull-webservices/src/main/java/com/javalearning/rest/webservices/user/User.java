package com.javalearning.rest.webservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class User {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private Integer id;	
	
	@Size(min = 2)
	@NotNull(message = "name should be not null")
	private String name;
	
	@Past
	private Date birthDay;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Post> posts;

	
	public User() {
		
	}

	public User(Integer id, String name, Date birthDay) {
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDay=" + birthDay + "]";
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	
	
	
	
	
	
}
