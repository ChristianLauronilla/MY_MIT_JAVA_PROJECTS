package com.fsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsp.entity.Section;

public class SectionMapper implements RowMapper<Section> {

	@Override
	public Section mapRow(ResultSet rs, int rowNum) throws SQLException {
		Section section = new Section();
		section.setSection_id(rs.getInt("section_id"));
		section.setSection_name(rs.getString("section_name"));
		section.setSection_capacity(rs.getInt("section_capacity"));
		section.setSection_status(rs.getString("section_status"));
		return section;
	}

}
