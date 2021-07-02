package com.abinanth.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abinanth.model.RecidencyModel;

@Repository
public class RecidencyRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	private final static String SQL = "insert into recidency(recidency_type) values(?)";
	private final static String SQL1 = "select*from recidency";
	private final static String SQL2 = "delete from recidency where recidency_type=?";

	public RecidencyModel save(RecidencyModel newRecidency) {
		jdbcTemplate.update(SQL, newRecidency.getRecidencyType());
		return newRecidency;

	}

	public String deleteRecidencyType(RecidencyModel deleteRecidency) {
		jdbcTemplate.update(SQL2, deleteRecidency.getRecidencyType());
		return "Data Deleted Successfully";

	}

	public List<RecidencyModel> findAll() {
		// return jdbcTemplate.query(SQL1,
		// BeanPropertyRowMapper.newInstance(RecidencyModel.class));
		return jdbcTemplate.query(SQL1, (rs, row) -> new RecidencyModel(rs.getString("recidency_type")));

	}

}
