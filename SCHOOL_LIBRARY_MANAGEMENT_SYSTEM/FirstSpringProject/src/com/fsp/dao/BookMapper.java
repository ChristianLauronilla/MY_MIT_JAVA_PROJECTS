package com.fsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsp.entity.Book;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setBook_title(rs.getString("book_title"));
		book.setBook_author(rs.getString("book_author"));
		book.setBook_price(rs.getDouble("book_price"));
		book.setBook_qty(rs.getInt("book_qty"));
		book.setBook_status(rs.getString("book_status"));
		return book;
	}

}
