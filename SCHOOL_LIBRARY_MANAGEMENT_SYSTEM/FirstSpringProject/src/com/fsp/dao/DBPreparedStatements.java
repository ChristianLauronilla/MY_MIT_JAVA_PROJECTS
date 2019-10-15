package com.fsp.dao;

public final class DBPreparedStatements {
	public static final String INSERT_PERSON = "INSERT INTO person(email_address, name, gender, birthday, address) VALUES(?, ?, ?, ?, ?)";
	public static final String INSERT_USERR = "INSERT INTO user(username,password,name,enabled,role) VALUES(?, ?, ?, ?, ?)";
	public static final String INSERT_USERRBORROWER = "INSERT INTO user(username,password,name,enabled,role) VALUES(?, ?, ?, ?, ?)";
	public static final String INSERT_BORROWER = "INSERT INTO borrower(borrower_name,borrower_address,borrower_type,borrower_added_date,borrower_status) VALUES(?, ?, ?, ?, ?)";
	public static final String INSERT_BOOK = "INSERT INTO book(book_title,book_author,book_price,book_qty,book_status) VALUES(?, ?, ?, ?, ?)";
	public static final String INSERT_BORROW = "INSERT INTO borrow(borrower_name,borrow_date,book_title,borrow_return_date,borrow_status) VALUES(?, ?, ?, ?, ?)";
	public static final String INSERT_LOCATION = "INSERT INTO location(username,password,name,enabled,role) VALUES(?, ?, ?, ?, ?)";
	public static final String UPDATE_PERSON = "UPDATE PERSON SET name=?, birthday=?, address=? WHERE email_address=?";
	public static final String UPDATE_USERR = "UPDATE user SET name=?, role=? WHERE username=?";
	public static final String UPDATE_BORROWER = "UPDATE borrower SET borrower_address=?, borrower_type=?, borrower_status=? WHERE borrower_name=?";
	public static final String UPDATE_BOOK = "UPDATE book SET book_author=?, book_price=?, book_qty=?, book_status=? WHERE book_title=?";
	public static final String UPDATE_BORROW = "UPDATE book SET book_qty=book_qty-1 WHERE book_title=?";
	public static final String UPDATE_BOOKRETURN = "UPDATE book SET book_qty=book_qty+1 WHERE book_title=?";
	public static final String UPDATE_BORROWRETURN = "UPDATE borrow SET borrow_status=?, borrow_return_date=? WHERE borrower_name=?";
	public static final String DELETE_PERSON = "DELETE FROM person WHERE email_address=?";
	public static final String DELETE_USERR = "DELETE FROM user WHERE username=?";
	public static final String DELETE_BORROWER = "DELETE FROM borrower WHERE borrower_name=?";
	public static final String DELETE_BOOK = "DELETE FROM book WHERE book_title=?";
	public static final String GET_ALL_PERSON = "SELECT * FROM person";
	public static final String GET_ALL_USERR = "SELECT * FROM user";
	public static final String GET_ALL_BORROWER = "SELECT * FROM borrower";
	public static final String GET_ALL_BOOK = "SELECT * FROM book";
	public static final String GET_ALL_GENDERS = "SELECT gender FROM gender";
	public static final String GET_ALL_LOCATION = "SELECT gender FROM location";
	public static final String GET_ALL_BORROW_ACTIVE = "SELECT * FROM borrow WHERE borrow_status='Active'";
	public static final String GET_ALL_BORROW_RETURNED = "SELECT * FROM borrow WHERE borrow_status='Returned'";
	public static final String SEARCH_PERSON = "SELECT * FROM person WHERE email_address=?";
	public static final String SEARCH_USERR = "SELECT * FROM user WHERE username=?";
	public static final String SEARCH_BORROWER = "SELECT * FROM borrower WHERE borrower_name=?";
	public static final String SEARCH_BORROW = "SELECT * FROM borrow WHERE borrower_name=? AND borrow_status='Active'";
	public static final String SEARCH_BOOK = "SELECT * FROM book WHERE book_title=?";
	public static final String INSERT_USER = "INSERT INTO user(email_address, first_name, last_name, gender, birthday) "
			+ "VALUES(?, ?, ?, ?, ?)";
	
}
