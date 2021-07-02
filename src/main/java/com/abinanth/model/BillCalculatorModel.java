package com.abinanth.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BillCalculatorModel {

	private String userName;
	private int recidencyId;
	private String recidenyType;
	private int recidencyNo;
	private String streetName;
	private String cityName;
	private String district;
	private int year;
}
