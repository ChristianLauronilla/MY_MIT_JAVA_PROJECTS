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
		userr.setName(rs.getString("name"));
		userr.setEnabled(rs.getString("enabled"));
		userr.setRole(rs.getString("role"));
		return userr;
	}

}
