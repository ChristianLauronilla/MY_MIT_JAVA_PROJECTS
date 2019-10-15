package com.fsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsp.entity.Userr;

public class UserrMapper implements RowMapper<Userr> {

	@Override
	public Userr mapRow(ResultSet rs, int rowNum) throws SQLException {
		Userr userr = new Userr();
		userr.setUsername(rs.getString("username"));
		userr.setPassword(rs.getString("password"));
		userr.setFname(rs.getString("fname"));
		userr.setLname(rs.getString("lname"));
		userr.setEnabled(rs.getString("enabled"));
		userr.setRole(rs.getString("role"));
		userr.setMobile_no(rs.getString("mobile_no"));
		userr.setDate_added(rs.getString("date_added"));
		return userr;
	}

}
