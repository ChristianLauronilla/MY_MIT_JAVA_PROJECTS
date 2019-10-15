package com.fsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsp.entity.Borrower;

public class BorrowerMapper implements RowMapper<Borrower> {

	@Override
	public Borrower mapRow(ResultSet rs, int rowNum) throws SQLException {
		Borrower borrower = new Borrower();
		borrower.setBorrower_name(rs.getString("borrower_name"));
		borrower.setBorrower_address(rs.getString("borrower_address"));
		borrower.setBorrower_type(rs.getString("borrower_type"));
		borrower.setBorrower_added_date(rs.getString("borrower_added_date"));
		borrower.setBorrower_status(rs.getString("borrower_status"));
		return borrower;
	}

}
