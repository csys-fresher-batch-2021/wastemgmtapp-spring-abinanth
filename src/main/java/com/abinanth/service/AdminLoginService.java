package com.abinanth.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class AdminLoginService {
//	@Autowired
//	LoginModel model;
	private static final HashMap<String, String> adminLoginDetails = new HashMap<>();
	static {
		adminLoginDetails.put("admin", "admin123");
	}

	public static boolean checkAdminLogin(String username, String password) {
		boolean adminValidation = false;

		if (adminLoginDetails.containsKey(username)) {
			System.out.println(adminValidation);
			String adminPassword = adminLoginDetails.get(username);
			if (adminPassword.equals(password)) {
				adminValidation = true;
				System.out.println(adminValidation);
			}
		}
		return adminValidation;
	}

}
