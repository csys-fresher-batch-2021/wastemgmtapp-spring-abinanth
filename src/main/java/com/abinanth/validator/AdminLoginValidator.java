package com.abinanth.validator;

import org.springframework.stereotype.Component;

@Component
public class AdminLoginValidator {
	private AdminLoginValidator() {
	}

	public static boolean adminValidation(String adminName, String password) {
		boolean valid = false;
		if ("admin".equals(adminName) && "admin".equals(password)) {
			valid = true;
		}
		return valid;
	}
}
