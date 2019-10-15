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
	
	public static final String INSERT_CERTIFICATE = "INSERT INTO certificate(certificate_name, certificate_amount) VALUES(?, ?)";
	public static final String UPDATE_CERTIFICATE = "UPDATE certificate SET certificate_name=?, certificate_amount=? WHERE certificate_id=?";
	public static final String GET_ALL_CERTIFICATE = "SELECT * FROM certificate";
	public static final String SEARCH_CERTIFICATE = "SELECT * FROM certificate WHERE certificate_id=?";
	public static final String DELETE_CERTIFICATE = "DELETE FROM certificate WHERE certificate_id=?";
	
	public static final String INSERT_ORDER = "INSERT INTO order_payment(entity_name,serial_no,fund_cluster,date_encoded,payor_name,payor_address,certificate_name,certificate_amount,prepared_by,approved_by,status) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SEARCH_CERTIFICATE_BY_NAME = "SELECT * FROM certificate WHERE certificate_name=?";
	public static final String GET_ALL_ORDER_ACTIVE = "SELECT * FROM order_payment WHERE status='Active'";
	public static final String GET_ALL_ORDER = "SELECT * FROM order_payment WHERE status='APPROVED'";
	public static final String SEARCH_ORDER_ACTIVE = "SELECT * FROM order_payment WHERE entity_name=? AND status='Active'";
	public static final String UPDATE_ORDER_APPROVE = "UPDATE order_payment SET status='APPROVED', approved_by=? WHERE entity_name=?";
	public static final String UPDATE_ORDER_DECLINE = "UPDATE order_payment SET status='DECLINED' WHERE entity_name=?";
}
