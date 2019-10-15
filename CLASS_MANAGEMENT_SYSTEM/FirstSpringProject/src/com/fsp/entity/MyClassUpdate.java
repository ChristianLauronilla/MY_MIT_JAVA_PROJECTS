package com.fsp.entity;

public class MyClassUpdate {
	private int id;
	private String section_name;
	private String teacher_username;
	private String student_id;
	private String student_name;
	private String class_status;
	
	public MyClassUpdate(String teacher_username) {
		super();
		this.teacher_username = teacher_username;
	}

	public MyClassUpdate() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public String getTeacher_username() {
		return teacher_username;
	}

	public void setTeacher_username(String teacher_username) {
		this.teacher_username = teacher_username;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getClass_status() {
		return class_status;
	}

	public void setClass_status(String class_status) {
		this.class_status = class_status;
	}

	
}
