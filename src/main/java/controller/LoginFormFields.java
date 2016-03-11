package main.java.controller;

public class LoginFormFields{
	private String user;
	private String pass;
	
	public LoginFormFields() {
	}
	
	public String getUsername() {
		return user;
	}
	public void setUsername(String username) {
		this.user = username;
	}
	public String getPassword() {
		return pass;
	}
	public void setPassword(String password) {
		this.pass = password;
	}
}
