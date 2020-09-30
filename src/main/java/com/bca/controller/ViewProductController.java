package com.bca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewProductController {

	@GetMapping("/product")
	public String viewProduct() {
		return "user/view_product";
	}
	
	@GetMapping("/product/detail")
	public String viewProductDetail() {
		return "user/view_product_detail";
	}
	
	@GetMapping("/product/category")
	public String viewProductCategory() {
		return "user/view_product_category";
	}
}
