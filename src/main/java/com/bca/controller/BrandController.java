package com.bca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brand")
public class BrandController {

	@GetMapping("/add")
	public String addProduct() {
		return "admin/brand_add";
	}
	
	@GetMapping("/list")
	public String listProduct() {
		return "admin/brand_list";
	}
}
