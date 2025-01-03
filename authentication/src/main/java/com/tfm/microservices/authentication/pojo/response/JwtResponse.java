package com.tfm.microservices.authentication.pojo.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwtToken;

	public JwtResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}
}