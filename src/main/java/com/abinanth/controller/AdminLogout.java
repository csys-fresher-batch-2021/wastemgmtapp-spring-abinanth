package com.abinanth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Servlet implementation class AdminLogout
 */
@Controller
public class AdminLogout {
	@GetMapping("/Logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:index.jsp";
	}
}
