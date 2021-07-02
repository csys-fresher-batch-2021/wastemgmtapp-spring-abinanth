package com.abinanth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.abinanth.model.RecidencyNo;
import com.abinanth.service.BillGeneratorService;

@RestController
public class PaymentController {
	@Autowired
	BillGeneratorService generateBillService;
	@Autowired
	RecidencyNo recidencyNo;

//	public double generateBill(RecidencyNo recidencyNo) {
//		return generateBillService.generateBill(recidencyNo);
//	}

}
