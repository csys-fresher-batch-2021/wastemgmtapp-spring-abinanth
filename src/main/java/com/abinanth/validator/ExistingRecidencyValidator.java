package com.abinanth.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abinanth.model.BillCalculatorModel;
import com.abinanth.repository.BillCalculatorRepository;

@Component
public class ExistingRecidencyValidator {
	private ExistingRecidencyValidator() {

	}

	@Autowired
	BillCalculatorRepository repo;

	public boolean isExistingRecidencyDetail(BillCalculatorModel addRecidencyDetails) {
		boolean isSame = true;
		List<BillCalculatorModel> recidencydetailsList = repo.findAll();
		for (BillCalculatorModel checkRecidencyDetails : recidencydetailsList) {
			if (checkRecidencyDetails.getRecidencyNo() == addRecidencyDetails.getRecidencyNo()
					|| checkRecidencyDetails.getCityName().equalsIgnoreCase(addRecidencyDetails.getCityName())
					|| checkRecidencyDetails.getDistrict().equalsIgnoreCase(addRecidencyDetails.getDistrict())
					|| checkRecidencyDetails.getStreetName().equalsIgnoreCase(addRecidencyDetails.getStreetName())
					|| checkRecidencyDetails.getYear() == addRecidencyDetails.getYear() && checkRecidencyDetails
							.getRecidenyType().equalsIgnoreCase(addRecidencyDetails.getRecidenyType())) {
				isSame = false;
			}
		}
		return isSame;
	}

}
