package com.abinanth.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abinanth.model.PaymentModel;
import com.abinanth.repository.PaymentRepository;

@Service
public class BillGeneratorService {
	@Autowired
	PaymentRepository repo;
	@Autowired
	PaymentModel paymentModel;

	/*
	 * this method calculates the bill
	 */
	public double generateBill(int recidencyNo, int year, String recidencyType) {
//		int userYear = recidencyNo.getYear();
//		String recidencyType = recidencyNo.getRecidencyType();
		double pay = 0;
		double amount = 0;
		if (recidencyType.equals("house")) {
			pay = 120;
		} else if (recidencyType.equals("shop")) {
			pay = 160;
		} else {
			pay = 200;
		}
		amount = isValidAmount(year, pay, amount);
		paymentModel.setRecidenyNo(recidencyNo);
		paymentModel.setAmount(amount);
		repo.save(paymentModel);
		return amount;
	}
	/*
	 * this method check the year is between 1 to 4
	 */

	public double isValidAmount(int year, double pay, double amount) {
		if (year < 4 || year > 0) {
			amount = pay * year;
		}
		return amount;
	}

	public LocalDate getDueDate() {
		LocalDate today = LocalDate.now();

		return today.plusDays(15);
	}
//	public boolean addPaymentDetails(PaymentModel newPayment) {
//		boolean flag = false;
//		try {
//			//newPayment.setFineAmount(0.0);
//			//repo.save(newPayment);
//			flag = true;
//		} catch (ValidationException e) {
//			e.printStackTrace();
//			throw new ValidationException("Unable to add details");
//		}
//		return flag;
//	}
}
