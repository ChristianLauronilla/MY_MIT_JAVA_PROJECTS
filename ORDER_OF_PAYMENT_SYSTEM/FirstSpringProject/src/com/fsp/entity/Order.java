package com.fsp.entity;

public class Order {
	
	private int order_id;
	private String entity_name;
	private String serial_no;
	private String fund_cluster;
	private String date_encoded;
	private String payor_name;
	private String payor_address;
	private String certificate_name;
	private double certificate_amount;
	private String prepared_by;
	private String approved_by;
	private String status;

	public Order(String entity_name, String serial_no, String fund_cluster, String date_encoded, String payor_name,
			String payor_address, String certificate_name, double certificate_amount, String prepared_by) {
		super();
		this.entity_name = entity_name;
		this.serial_no = serial_no;
		this.fund_cluster = fund_cluster;
		this.date_encoded = date_encoded;
		this.payor_name = payor_name;
		this.payor_address = payor_address;
		this.certificate_name = certificate_name;
		this.certificate_amount = certificate_amount;
		this.prepared_by = prepared_by;
	}
	
	public Order() {
		super();
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getEntity_name() {
		return entity_name;
	}

	public void setEntity_name(String entity_name) {
		this.entity_name = entity_name;
	}

	public String getFund_cluster() {
		return fund_cluster;
	}

	public void setFund_cluster(String fund_cluster) {
		this.fund_cluster = fund_cluster;
	}

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public String getDate_encoded() {
		return date_encoded;
	}

	public void setDate_encoded(String date_encoded) {
		this.date_encoded = date_encoded;
	}

	public String getPayor_name() {
		return payor_name;
	}

	public void setPayor_name(String payor_name) {
		this.payor_name = payor_name;
	}

	public String getPayor_address() {
		return payor_address;
	}

	public void setPayor_address(String payor_address) {
		this.payor_address = payor_address;
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

	public String getPrepared_by() {
		return prepared_by;
	}

	public void setPrepared_by(String prepared_by) {
		this.prepared_by = prepared_by;
	}

	public String getApproved_by() {
		return "";
	}

	public void setApproved_by(String approved_by) {
		this.approved_by = approved_by;
	}

	public String getStatus() {
		return "Active";
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
