package com.fsp.entity;

public class Certificate {
	private int certificate_id;
	private String certificate_name;
	private double certificate_amount;
	
	public Certificate(int certificate_id, String certificate_name, double certificate_amount) {
		super();
		this.certificate_id = certificate_id;
		this.certificate_name = certificate_name;
		this.certificate_amount = certificate_amount;
	}
	
	public Certificate(String certificate_name, double certificate_amount) {
		super();
		this.certificate_name = certificate_name;
		this.certificate_amount = certificate_amount;
	}
	

	public Certificate() {
		super();
	}

	public int getCertificate_id() {
		return certificate_id;
	}

	public void setCertificate_id(int certificate_id) {
		this.certificate_id = certificate_id;
	}

	public String getCertificate_name() {
		return certificate_name;
	}

	public void setCertificate_name(String certificate_name) {
		this.certificate_name = certificate_name;
	}

	public double getCertificate_amount() {
		return certificate_amount;
	}

	public void setCertificate_amount(double certificate_amount) {
		this.certificate_amount = certificate_amount;
	}



}
