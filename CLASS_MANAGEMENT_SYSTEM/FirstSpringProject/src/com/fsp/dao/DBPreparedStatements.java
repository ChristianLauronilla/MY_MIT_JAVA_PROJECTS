package com.fsp.dao;

public final class DBPreparedStatements {
	public static final String INSERT_PERSON = "INSERT INTO person(email_address, name, gender, birthday, address) VALUES(?, ?, ?, ?, ?)";
	public static final String INSERT_USERR = "INSERT INTO user(username,password,fname,lname,enabled,role,mobile_no,date_added,status) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String INSERT_STUDENT = "INSERT INTO student(student_id,student_fname,student_lname,student_mobile_no,student_date_added,student_status) VALUES(?, ?, ?, ?, ?, ?)";
	public static final String INSERT_LOCATION = "INSERT INTO location(username,password,name,enabled,role) VALUES(?, ?, ?, ?, ?)";
	public static final String INSERT_SECTION = "INSERT INTO section(section_name,section_capacity,section_status) VALUES(?, ?, ?)";
	public static final String INSERT_CLASSASSIGNMENT = "INSERT INTO myclass(section_name,teacher_username,student_name,student_id,class_status) VALUES(?, ?, ?, ?, ?)";
	public static final String UPDATE_PERSON = "UPDATE PERSON SET name=?, birthday=?, address=? WHERE email_address=?";
	public static final String UPDATE_USERR = "UPDATE user SET password=?,fname=?,lname=?,mobile_no=?,date_added=?,role=? WHERE username=?";
	public static final String UPDATE_STUDENT = "UPDATE student SET student_fname=?,student_lname=?,student_mobile_no=?,student_date_added=?,student_status=? WHERE student_id=?";
	public static final String UPDATE_SECTION = "UPDATE section SET section_capacity=?,section_status=? WHERE section_name=?";
	public static final String UPDATE_SECTION_MINUSCAPACITY_CLASSASSIGNMENT = "UPDATE section SET section_capacity=section_capacity-1 WHERE section_name=?";
	public static final String UPDATE_STUDENT_ASSIGNED_CLASSASSIGNMENT = "UPDATE student SET student_status='Assigned' WHERE student_id=?";
	public static final String UPDATE_STUDENT_CLASSSTATUSTONULL = "UPDATE myclass SET class_status=''";
	public static final String UPDATE_CLASS_TO_VIEW = "UPDATE myclass SET class_status='view' WHERE teacher_username=?";
	public static final String DELETE_PERSON = "DELETE FROM person WHERE email_address=?";
	public static final String DELETE_USERR = "DELETE FROM user WHERE username=?";
	public static final String DELETE_STUDENT = "DELETE FROM student WHERE student_id=?";
	public static final String DELETE_SECTION = "DELETE FROM section WHERE section_name=?";
	public static final String GET_ALL_PERSON = "SELECT * FROM person";
	public static final String GET_ALL_USERR = "SELECT * FROM user";
	public static final String GET_ALL_SECTION = "SELECT * FROM section";
	public static final String GET_ALL_MYCLASS = "SELECT * FROM myclass WHERE class_status='view'";
	public static final String GET_ALL_TEACHERFNAME = "SELECT * FROM user WHERE role='ROLE_USER' AND status='Active'";
	public static final String GET_ALL_SECTION_CLASSASSIGNMENT = "SELECT * FROM section WHERE section_status='Active' AND section_capacity > 0";
	public static final String GET_ALL_STUDENT_CLASSASSIGNMENT = "SELECT * FROM student WHERE student_status='Active'";
	public static final String GET_ALL_STUDENT = "SELECT * FROM student";
	public static final String GET_ALL_GENDERS = "SELECT gender FROM gender";
	public static final String GET_ALL_LOCATION = "SELECT gender FROM location";
	public static final String SEARCH_PERSON = "SELECT * FROM person WHERE email_address=?";
	public static final String SEARCH_USERR = "SELECT * FROM user WHERE username=?";
	public static final String SEARCH_STUDENT = "SELECT * FROM student WHERE student_id=?";
	public static final String SEARCH_SECTION = "SELECT * FROM section WHERE section_name=?";
	public static final String INSERT_USER = "INSERT INTO user(email_address, first_name, last_name, gender, birthday) "
			+ "VALUES(?, ?, ?, ?, ?)";
	
}
