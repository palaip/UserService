package com.sample.user.userService.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "micro_user")
@Setter
@Getter
public class User {

	@Id
	@Column(name = "ID")
	private String userId;

	@Column(name = "NAME", length = 12)
	private String name;
	@Column(name = "EMAIL", length = 34)
	private String email;

	@Column(name = "ABOUT")
	private String about;
	
	@Transient
	private List<Rating> ratings;

}
