package com.alstonia.spring.boot.authentication.api.model;

public class AuthenticationRequest {
	private String username;
	private String password;
	public AuthenticationRequest() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}