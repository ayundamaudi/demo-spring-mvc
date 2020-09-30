package com.bca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class CustomerController {

	
	@GetMapping("/list")
	public String listProduct() {
		return "admin/user_list";
	}
}
