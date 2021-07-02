package com.abinanth.validator;

import org.springframework.stereotype.Component;

@Component
public class RecidencyStringValidator {
	private RecidencyStringValidator() {

	}

	/**
	 * // String validation is performed // insertion of numbers is recidency type
	 * is checked
	 * 
	 * @param newRecidencyName
	 * @return
	 */
	public static boolean stringValidation(String username) {
		boolean isValidService = true;
		if (username.length() == 0 || username.trim().equals("")) {
			isValidService = false;
		}
		for (int index = 0; index < username.length(); index++) {
			if (username.charAt(index) >= '0' && username.charAt(index) <= '9') {
				isValidService = false;
			}
		}
		return isValidService;
	}
}
