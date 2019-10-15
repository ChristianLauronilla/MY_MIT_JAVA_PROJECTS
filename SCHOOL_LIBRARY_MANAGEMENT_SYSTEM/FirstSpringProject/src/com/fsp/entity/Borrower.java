package com.fsp.entity;

public class Borrower {
	private int borrower_id;
	private String borrower_name;
	private String borrower_address;
	private String borrower_type;
	private String borrower_added_date;
	private String borrower_status;
	private String borrower_status_active;

	public Borrower(String borrower_name, String borrower_address, String borrower_type, String borrower_added_date) {
		super();
		this.borrower_name = borrower_name;
		this.borrower_address = borrower_address;
		this.borrower_type = borrower_type;
		this.borrower_added_date = borrower_added_date;
	}
	
	

	public Borrower() {
		super();
	}
	
	public int getBorrower_id() {
		return borrower_id;
	}

	public void setBorrower_id(int borrower_id) {
		this.borrower_id = borrower_id;
	}

	public String getBorrower_address() {
		return borrower_address;
	}

	public void setBorrower_address(String borrower_address) {
		this.borrower_address = borrower_address;
	}

	public String getBorrower_type() {
		return borrower_type;
	}

	public void setBorrower_type(String borrower_type) {
		this.borrower_type = borrower_type;
	}

	public String getBorrower_added_date() {
		return borrower_added_date;
	}

	public void setBorrower_added_date(String borrower_added_date) {
		this.borrower_added_date = borrower_added_date;
	}

	public String getBorrower_status() {
		return borrower_status;
	}

	public void setBorrower_status(String borrower_status) {
		this.borrower_status = borrower_status;
	}

	public String getBorrower_name() {
		return borrower_name;
	}

	public void setBorrower_name(String borrower_name) {
		this.borrower_name = borrower_name;
	}


	public String getBorrower_status_active() {
		return "Active";
	}


	public void setBorrower_status_active(String borrower_status_active) {
		this.borrower_status_active = borrower_status_active;
	}
	

}
