package com.fsp.entity;

public class Person {
	private String emailAddress;
	private String name;
	private String gender;
	private String birthday;
	private String address;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String emailAddress, String name, String gender, String birthday, String address) {
		super();
		this.emailAddress = emailAddress;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
