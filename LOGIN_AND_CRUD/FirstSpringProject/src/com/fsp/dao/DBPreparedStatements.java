package com.fsp.dao;

public final class DBPreparedStatements {
	public static final String INSERT_PERSON = "INSERT INTO person(email_address, name, gender, birthday, address) VALUES(?, ?, ?, ?, ?)";
	public static final String INSERT_USERR = "INSERT INTO user(username,password,name,enabled,role) VALUES(?, ?, ?, ?, ?)";
	public static final String INSERT_LOCATION = "INSERT INTO location(username,password,name,enabled,role) VALUES(?, ?, ?, ?, ?)";
	public static final String UPDATE_PERSON = "UPDATE PERSON SET name=?, birthday=?, address=? WHERE email_address=?";
	public static final String UPDATE_USERR = "UPDATE user SET name=?, role=? WHERE username=?";
	public static final String DELETE_PERSON = "DELETE FROM person WHERE email_address=?";
	public static final String DELETE_USERR = "DELETE FROM user WHERE username=?";
	public static final String GET_ALL_PERSON = "SELECT * FROM person";
	public static final String GET_ALL_USERR = "SELECT * FROM user";
	public static final String GET_ALL_GENDERS = "SELECT gender FROM gender";
	public static final String GET_ALL_LOCATION = "SELECT gender FROM location";
	public static final String SEARCH_PERSON = "SELECT * FROM person WHERE email_address=?";
	public static final String SEARCH_USERR = "SELECT * FROM user WHERE username=?";
	public static final String INSERT_USER = "INSERT INTO user(email_address, first_name, last_name, gender, birthday) "
			+ "VALUES(?, ?, ?, ?, ?)";
	
}
