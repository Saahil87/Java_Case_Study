package com.accenture.lkm.business.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginBean {
	@NotNull(message="username cannot be empty")
	private String username;
	@NotNull(message="password cannot be empty")
	@Size(min=3, max=10, message="Password should contain min 3 and max 10 characters")
	private String password;
	
	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	
	@Override
	public String toString() {
		return "LoginBean [username=" + username + ", password=" + password + "]";
	}
	
	

}