package com.fsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsp.entity.Borrow;

public class BorrowMapper implements RowMapper<Borrow> {

	@Override
	public Borrow mapRow(ResultSet rs, int rowNum) throws SQLException {
		Borrow borrow = new Borrow();
		borrow.setBorrower_name(rs.getString("borrower_name"));
		borrow.setBorrow_date(rs.getString("borrow_date"));
		borrow.setBook_title(rs.getString("book_title"));
		borrow.setBorrow_return_date(rs.getString("borrow_return_date"));
		borrow.setBorrow_status(rs.getString("borrow_status"));
		return borrow;
	}

}
