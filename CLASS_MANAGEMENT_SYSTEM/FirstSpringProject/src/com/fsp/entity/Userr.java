package com.fsp.entity;

public class Userr {
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String mobile_no;
	private String date_added;
	private String status;
	private String enabled;
	private String role;

	public Userr(String username, String password, String fname, String lname, String role, String mobile_no, String date_added) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.role = role;
		this.mobile_no = mobile_no;
		this.date_added = date_added;
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	public String getStatus() {
		return "Active";
	}

	public void setStatus(String status) {
		this.status = status;
	}



}
