package com.fsp.entity;

public class Section {
	private int section_id;
	private String section_name;
	private int section_capacity;
	private String section_status;

	public Section(String section_name, int section_capacity, String section_status) {
		super();
		this.section_name = section_name;
		this.section_capacity = section_capacity;
		this.section_status = section_status;
	}

	public Section(int section_capacity, String section_status,String section_name) {
		super();
		this.section_capacity = section_capacity;
		this.section_status = section_status;
		this.section_name = section_name;
	}
	
	public Section(String section_name) {
		super();
		this.section_name = section_name;
	}
	
	public Section() {
		super();
	}

	public int getSection_id() {
		return section_id;
	}

	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public int getSection_capacity() {
		return section_capacity;
	}

	public void setSection_capacity(int section_capacity) {
		this.section_capacity = section_capacity;
	}

	public String getSection_status() {
		return section_status;
	}

	public void setSection_status(String section_status) {
		this.section_status = section_status;
	}

	
}
