package com.abinanth.model;

import java.time.LocalDate;

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
public class PaymentModel {
	private int paymentId;
	private int recidenyNo;
	private double amount;
	private String status;
	private LocalDate dueDate;
	private double fineAmount;
	private LocalDate paidDate;
	private double totalAmount;

}
