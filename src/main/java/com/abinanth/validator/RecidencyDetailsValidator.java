package com.abinanth.validator;

import org.springframework.stereotype.Component;

import com.abinanth.model.BillCalculatorModel;

@Component
public class RecidencyDetailsValidator {
	private RecidencyDetailsValidator() {

	}

	public boolean isValidRecidency(BillCalculatorModel addRecidencyDetails) {
		boolean isValid = true;

		if (!BillCalculatorValidator.recidencyTypeValidation(addRecidencyDetails.getRecidenyType())) {

			isValid = false;
		}

		if (!BillCalculatorValidator.recidencyTypeValidation(addRecidencyDetails.getStreetName())) {

			isValid = false;
		}
		if (!BillCalculatorValidator.recidencyTypeValidation(addRecidencyDetails.getCityName())) {

			isValid = false;
		}
		if (!BillCalculatorValidator.recidencyTypeValidation(addRecidencyDetails.getDistrict())) {

			isValid = false;
		}
		return isValid;
	}

}
