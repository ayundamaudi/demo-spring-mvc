package com.bca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String dashboardPage() {
		return "user/index";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "user/profile_user";
	}
	
	@GetMapping("/profile/update")
	public String profileUpdate() {
		return "user/update_profile_user";
	}
	
	@GetMapping("/profile/password/update")
	public String updatePassword() {
		return "user/update_password";
	}
	
	@GetMapping("/profile/address")
	public String address() {
		return "user/address";
	}
	
	@GetMapping("/profile/address/add")
	public String addressAdd() {
		return "user/address_add";
	}

	
	@GetMapping("/profile/ewallet")
	public String ewallet() {
		return "user/ewallet";
	}
	
}
