package com.fsp.entity;

public class BorrowUpdateReturn {
	private String borrower_name;
	private String book_title;
	private String borrow_return_date;
	private String borrow_status;
	
	public BorrowUpdateReturn(String borrower_name, String book_title, String borrow_return_date) {
		super();
		this.setBorrower_name(borrower_name);
		this.setBook_title(book_title);
		this.setBorrow_return_date(borrow_return_date);
	}	
	
	public BorrowUpdateReturn() {
		super();
	}

	public String getBorrower_name() {
		return borrower_name;
	}

	public void setBorrower_name(String borrower_name) {
		this.borrower_name = borrower_name;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBorrow_return_date() {
		return borrow_return_date;
	}

	public void setBorrow_return_date(String borrow_return_date) {
		this.borrow_return_date = borrow_return_date;
	}

	public String getBorrow_status() {
		return "Returned";
	}

	public void setBorrow_status(String borrow_status) {
		this.borrow_status = borrow_status;
	}
	
}
