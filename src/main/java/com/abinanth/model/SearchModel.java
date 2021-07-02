package com.abinanth.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchModel {
	private String word;
	private int paymentId;
	private int recidencyNo;
	private String recidnecyType;
	private String status;
	private LocalDate dueDate;
	private LocalDate paidDate;
	private double totalAmount;
	private double amount;

}
