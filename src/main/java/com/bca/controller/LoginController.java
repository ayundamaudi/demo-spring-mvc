package com.bca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping ("/user")
	public String login() {
		return "user/login_user";
	}
	
	@GetMapping("/register")
	public String register() {
		return "user/register_user";
	}
	
	@GetMapping("/forget/password")
	public String forgetPassword() {
		return "user/forget_password";
	}
}
