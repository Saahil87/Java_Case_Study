package com.accenture.lkm.business.bean;

import org.hibernate.validator.constraints.NotBlank;

public class LoginBean {
	@NotBlank(message="username cannot be empty")
	private String username;
	@NotBlank(message="password cannot be empty")
	private String password;
	
	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*public LoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}*/
	
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
	
	@Override
	public String toString() {
		return "LoginBean [username=" + username + ", password=" + password + "]";
	}
	
	

}