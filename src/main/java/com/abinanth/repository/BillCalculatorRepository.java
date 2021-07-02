package com.abinanth.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abinanth.model.BillCalculatorModel;

@Repository
public class BillCalculatorRepository {
	private final static String SQL1 = "select*from bill_details";
	private final static String SQL = "insert into bill_details(user_name,recidency_type,recidency_no,street_name,city_name,district_name,years) values(?,?,?,?,?,?,?)";
	@Autowired
	JdbcTemplate jdbcTemplate;

	public BillCalculatorModel save(BillCalculatorModel addBill) {
		jdbcTemplate.update(SQL, addBill.getUserName(), addBill.getRecidenyType(), addBill.getRecidencyNo(),
				addBill.getStreetName(), addBill.getCityName(), addBill.getDistrict(), addBill.getYear());
		return addBill;
	}

	public List<BillCalculatorModel> findAll() {
		return jdbcTemplate.query(SQL1, (rs, getDetails) -> new BillCalculatorModel(rs.getString(2), rs.getInt(1),
				rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
	}
}
