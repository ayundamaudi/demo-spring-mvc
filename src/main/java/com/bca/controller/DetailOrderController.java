package com.bca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detail")
public class DetailOrderController {

	@GetMapping("/order")
	public String Order() {
		return "user/order";
	}
	
	@GetMapping("/order/view")
	public String detailOrder() {
		return "user/detail_order";
	}

}
