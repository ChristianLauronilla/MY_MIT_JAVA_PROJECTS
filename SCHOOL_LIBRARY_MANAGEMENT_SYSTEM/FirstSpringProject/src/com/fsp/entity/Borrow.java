package com.fsp.entity;

public class Borrow {
	private int borrow_id;
	private String borrower_name;
	private String borrow_date;
	private String book_title;
	private String borrow_return_date;
	private String borrow_status;
	
	public Borrow(String borrower_name, String borrow_date, String book_title, String borrow_status) {
		super();
		this.borrower_name = borrower_name;
		this.borrow_date = borrow_date;
		this.book_title = book_title;
		this.borrow_status = borrow_status;
	}	
	
	public Borrow() {
		super();
	}

	public int getBorrow_id() {
		return borrow_id;
	}

	public void setBorrow_id(int borrow_id) {
		this.borrow_id = borrow_id;
	}

	public String getBorrower_name() {
		return borrower_name;
	}

	public void setBorrower_name(String borrower_name) {
		this.borrower_name = borrower_name;
	}

	public String getBorrow_return_date() {
		return "";
	}

	public void setBorrow_return_date(String borrow_return_date) {
		this.borrow_return_date = borrow_return_date;
	}

	public String getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}

	public String getBorrow_status() {
		return borrow_status;
	}

	public void setBorrow_status(String borrow_status) {
		this.borrow_status = borrow_status;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	

	
	
}
