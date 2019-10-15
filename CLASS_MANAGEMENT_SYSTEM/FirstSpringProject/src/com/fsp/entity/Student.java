package com.fsp.entity;

public class Student {
	private String student_id;
	private String student_fname;
	private String student_lname;
	private String student_mobile_no;
	private String student_date_added;
	private String student_status;

	public Student(String student_id, String student_fname, String student_lname, String student_mobile_no, String student_date_added, String student_status) {
		super();
		this.student_id = student_id;
		this.student_fname = student_fname;
		this.student_lname = student_lname;
		this.student_mobile_no = student_mobile_no;
		this.student_date_added = student_date_added;
		this.student_status = student_status;
	}
	
	public Student(String student_id) {
		super();
		this.student_id = student_id;
	}

	public Student() {
		super();
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_fname() {
		return student_fname;
	}

	public void setStudent_fname(String student_fname) {
		this.student_fname = student_fname;
	}

	public String getStudent_lname() {
		return student_lname;
	}

	public void setStudent_lname(String student_lname) {
		this.student_lname = student_lname;
	}

	public String getStudent_mobile_no() {
		return student_mobile_no;
	}

	public void setStudent_mobile_no(String student_mobile_no) {
		this.student_mobile_no = student_mobile_no;
	}

	public String getStudent_date_added() {
		return student_date_added;
	}

	public void setStudent_date_added(String student_date_added) {
		this.student_date_added = student_date_added;
	}

	public String getStudent_status() {
		return student_status;
	}

	public void setStudent_status(String student_status) {
		this.student_status = student_status;
	}

	
}
