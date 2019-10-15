package com.fsp.entity;

public class Userr {
	private String username;
	private String password;
	private String name;
	private String enabled;
	private String role;

	public Userr(String username, String password, String name, String role) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.role = role;
	}
	
	public Userr(String username, String name, String role) {
		super();
		this.username = username;
		this.name = name;
		this.role = role;
	}

	public Userr() {
		super();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnabled() {
		return "1";
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



}
