package com.abinanth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BillCalculatorDTO {
	private String userName;
	private int recidencyId;
	private String recidenyType;
	private int recidencyNo;
	private String streetName;
	private String cityName;
	private String district;
	private int year;

}
