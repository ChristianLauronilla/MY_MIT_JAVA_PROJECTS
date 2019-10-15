package com.fsp.entity;

public class Book {
	private int book_id;
	private String book_title;
	private String book_author;
	private double book_price;
	private int book_qty;
	private String book_status;
	
	public Book(String book_title, String book_author, double book_price, int book_qty) {
		super();
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_price = book_price;
		this.book_qty = book_qty;
	}
	
	public Book() {
		super();
	}
	

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public double getBook_price() {
		return book_price;
	}

	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}

	public int getBook_qty() {
		return book_qty;
	}

	public void setBook_qty(int book_qty) {
		this.book_qty = book_qty;
	}

	public String getBook_status() {
		return "Active";
	}

	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}
	
}
