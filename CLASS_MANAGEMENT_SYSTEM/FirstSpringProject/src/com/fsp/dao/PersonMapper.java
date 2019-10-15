package com.fsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsp.entity.Person;

public class PersonMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setEmailAddress(rs.getString("email_address"));
		person.setName(rs.getString("name"));
		person.setGender(rs.getString("gender"));
		person.setBirthday(rs.getString("birthday"));
		person.setAddress(rs.getString("address"));
		return person;
	}

}
