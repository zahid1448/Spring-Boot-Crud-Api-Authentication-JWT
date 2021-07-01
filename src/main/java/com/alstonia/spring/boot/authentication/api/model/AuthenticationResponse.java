package com.alstonia.spring.boot.authentication.api.model;

public class AuthenticationResponse {
private final String jwt;

public AuthenticationResponse(String jwt) {
	super();
	this.jwt = jwt;
}

public String getJwt() {
	return jwt;
}

}
