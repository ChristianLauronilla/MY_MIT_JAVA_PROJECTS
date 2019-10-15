package com.fsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsp.entity.Certificate;

public class CertificateMapper implements RowMapper<Certificate> {

	@Override
	public Certificate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Certificate certificate = new Certificate();
		certificate.setCertificate_id(rs.getInt("certificate_id"));
		certificate.setCertificate_name(rs.getString("certificate_name"));
		certificate.setCertificate_amount(rs.getDouble("certificate_amount"));
		return certificate;
	}

}
