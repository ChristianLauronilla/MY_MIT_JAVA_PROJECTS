package com.fsp.entity;

public class BorrowUpdate {
	private String book_title;
	
	public BorrowUpdate(String book_title) {
		super();
		this.setBook_title(book_title);
	}
	
	
	public BorrowUpdate() {
		super();
	}


	public String getBook_title() {
		return book_title;
	}


	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	
	
	
}
