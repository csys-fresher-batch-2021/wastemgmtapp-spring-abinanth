package com.abinanth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abinanth.dto.LoginDTO;
import com.abinanth.dto.Message;
import com.abinanth.service.AdminLoginService;

@RestController
public class AdminLoginController {

	@Autowired
	AdminLoginService loginService;

	@PostMapping("adminLoginServlet")
	public ResponseEntity<Message> AdminLogin(@RequestBody LoginDTO login, HttpServletRequest request) {
		String userName = login.getUserName();
		HttpSession session = request.getSession();
		session.setAttribute("adminName", userName);
		String password = login.getPassword();
		session.setAttribute("password", password);
		boolean isValid = AdminLoginService.checkAdminLogin(userName, password);

		HttpStatus httpStatus;
		Message message = new Message();
		try {
			if (isValid) {
				message.setInfoMessage("Login Successfull");
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
