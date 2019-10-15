package com.fsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsp.entity.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudent_id(rs.getString("student_id"));
		student.setStudent_fname(rs.getString("student_fname"));
		student.setStudent_lname(rs.getString("student_lname"));
		student.setStudent_mobile_no(rs.getString("student_mobile_no"));
		student.setStudent_date_added(rs.getString("student_date_added"));
		student.setStudent_status(rs.getString("student_status"));
		return student;
	}

}
