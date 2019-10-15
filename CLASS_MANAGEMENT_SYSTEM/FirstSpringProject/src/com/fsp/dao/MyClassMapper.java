package com.fsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsp.entity.MyClass;

public class MyClassMapper implements RowMapper<MyClass> {

	@Override
	public MyClass mapRow(ResultSet rs, int rowNum) throws SQLException {
		MyClass myclass = new MyClass();
		myclass.setSection_name(rs.getString("section_name"));
		myclass.setStudent_id(rs.getString("student_id"));
		myclass.setStudent_name(rs.getString("student_name"));
		return myclass;
	}

}
