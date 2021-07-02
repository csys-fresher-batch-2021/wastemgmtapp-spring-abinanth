package com.abinanth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abinanth.dto.RecidencyDTO;
import com.abinanth.model.RecidencyModel;
import com.abinanth.service.RecidencyTypeService;

@RestController
public class RecidencyController {
	@Autowired
	RecidencyTypeService recidencyService;
	@Autowired
	RecidencyModel model;

	@GetMapping("getAllRecidency")
	public List<RecidencyModel> displayRecidencyType() {

		return recidencyService.displayRecidencyType();
	}

	@GetMapping("listAllRecidency")
	public List<RecidencyModel> ListRecidencyType() {

		return recidencyService.displayRecidencyType();
	}

	@PostMapping("insertRecidency")
	public boolean updateRecidency(@RequestBody RecidencyDTO newRecidency) {
		String recidencyType = newRecidency.getRecidencyType();
		model.setRecidencyType(recidencyType);
		System.out.print(model);
		return recidencyService.addRecidencyType(model);
	}

	@DeleteMapping("deleteRecidency/{id}")
	public boolean updateRecidency(@PathVariable("id") String deleteRecidency) {
		model.setRecidencyType(deleteRecidency);
		System.out.println(model);
		return recidencyService.deleteRecidencyType(model);
	}
}
