package com.abinanth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abinanth.dto.BillCalculatorDTO;
import com.abinanth.dto.Message;
import com.abinanth.model.BillCalculatorModel;
import com.abinanth.service.BillCalculatorService;
import com.abinanth.service.BillGeneratorService;

@RestController
public class BillCalculatorController {
	@Autowired
	BillCalculatorService billCalculation;
	@Autowired
	BillGeneratorService generateBillService;
	@Autowired
	Message message;
//	RecidencyNo recidencyNo;

	@PostMapping("BillCalculator")
	public ResponseEntity<Message> getBillDetails(@RequestBody BillCalculatorDTO billDetails) {
		// List<BillCalculatorModel> list = new ArrayList<>();
		String username = billDetails.getUserName();
		String streetName = billDetails.getStreetName();
		String district = billDetails.getDistrict();
		String cityName = billDetails.getCityName();
		int recidencyNo = billDetails.getRecidencyNo();
		String recidencyType = billDetails.getRecidenyType();
		int year = billDetails.getYear();
		BillCalculatorModel billModel = new BillCalculatorModel();
		billModel.setUserName(username);
		billModel.setCityName(cityName);
		billModel.setDistrict(district);
		billModel.setRecidencyNo(recidencyNo);
		billModel.setRecidenyType(recidencyType);
		billModel.setYear(year);
		billModel.setStreetName(streetName);
		boolean isValid = billCalculation.addRecidencyDetails(billModel);
		generateBillService.generateBill(recidencyNo, year, recidencyType);
		HttpStatus httpStatus;
		// Message message = new Message();
		try {
			if (isValid) {

				message.setInfoMessage("Bill Generated Successfully");
				httpStatus = HttpStatus.OK;
			} else {
				message.setErrorMessage("Unsuccessful");
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setErrorMessage("Unsuccessfull");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>(message, httpStatus);
	}
}
