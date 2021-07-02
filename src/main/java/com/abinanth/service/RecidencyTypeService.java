package com.abinanth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abinanth.model.RecidencyModel;
import com.abinanth.repository.RecidencyRepository;

@Service
public class RecidencyTypeService {

	/*
	 * this method is used get all recidency type
	 */
	@Autowired
	RecidencyRepository repo;

	public List<RecidencyModel> displayRecidencyType() {

		return repo.findAll();
	}

	/*
	 * this method add the recidency type into recidencytype database
	 */
	public boolean addRecidencyType(RecidencyModel newRecidency) {
		boolean valid = false;
		boolean exists = false;
		List<RecidencyModel> recidencyTypes = repo.findAll();
		for (RecidencyModel recidencyModel : recidencyTypes) {
			if (recidencyModel.getRecidencyType().equalsIgnoreCase(newRecidency.getRecidencyType())) {
				exists = true;
				break;
			}
		}
		if (!exists) {
			repo.save(newRecidency);
			valid = true;
		}
		return valid;
	}

	/*
	 * this method delete the recidency type
	 */
	public boolean deleteRecidencyType(RecidencyModel deleteRecidency) {
		boolean valid = false;
		List<RecidencyModel> recidencyType = repo.findAll();
		for (RecidencyModel recidency : recidencyType) {
			String deleteRecidency2 = recidency.getRecidencyType();
			if (deleteRecidency != null && deleteRecidency2.equalsIgnoreCase(deleteRecidency.getRecidencyType())) {
				valid = true;
			}
		}
		if (valid) {
			repo.deleteRecidencyType(deleteRecidency);
		}
		return valid;
	}

}
