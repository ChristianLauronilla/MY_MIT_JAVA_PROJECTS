package com.fsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsp.entity.OrderUpdate;

public class OrderUpdateMapper implements RowMapper<OrderUpdate> {

	@Override
	public OrderUpdate mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderUpdate order = new OrderUpdate();
		order.setOrder_id(rs.getInt("order_id"));
		order.setEntity_name(rs.getString("entity_name"));
		order.setSerial_no(rs.getString("serial_no"));
		order.setFund_cluster(rs.getString("fund_cluster"));
		order.setDate_encoded(rs.getString("date_encoded"));
		order.setPayor_name(rs.getString("payor_name"));
		order.setPayor_address(rs.getString("payor_address"));
		order.setCertificate_name(rs.getString("certificate_name"));
		order.setCertificate_amount(rs.getDouble("certificate_amount"));
		order.setPrepared_by(rs.getString("prepared_by"));
		order.setApproved_by(rs.getString("approved_by"));
		order.setStatus(rs.getString("status"));
		return order;
	}
}
