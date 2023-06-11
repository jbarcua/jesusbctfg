package com.tfm.microservices.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Data
@Entity
@Table(name = "user")
public class UserData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	@JsonIgnore
	private String password;
}