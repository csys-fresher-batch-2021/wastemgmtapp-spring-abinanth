package com.abinanth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abinanth.exception.ValidationException;
import com.abinanth.model.BillCalculatorModel;
import com.abinanth.repository.BillCalculatorRepository;
import com.abinanth.validator.ExistingRecidencyValidator;
import com.abinanth.validator.RecidencyDetailsValidator;

@Service
public class BillCalculatorService {

	@Autowired
	BillCalculatorRepository billRepo;
	@Autowired
	ExistingRecidencyValidator existing;
	@Autowired
	RecidencyDetailsValidator detailValidator;

	// static Logger log = new Logger();
	// static RecidencyDetailsDAO dao = new RecidencyDetailsDAO();

	/*
	 * this method is used to get the recidency type
	 */
	public List<BillCalculatorModel> getAllRecidencyType() {
		return billRepo.findAll();
	}

	/*
	 * this method is used to add recidency type
	 */
	public boolean addRecidencyDetails(BillCalculatorModel recidencyFeilds) {
		boolean isValid = false;
		try {
			boolean existingRecidencyValue = existing.isExistingRecidencyDetail(recidencyFeilds);
			boolean correctdetail = detailValidator.isValidRecidency(recidencyFeilds);
			if (!existingRecidencyValue) {
				throw new ValidationException("Already exists");
			}
			if (!correctdetail) {
				throw new ValidationException("Invalid Details");
			}
			billRepo.save(recidencyFeilds);
			isValid = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}
}
