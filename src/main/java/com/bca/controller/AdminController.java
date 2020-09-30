package com.bca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bca.entity.Admin;
import com.bca.repo.AdminRepo;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminRepo adminRepo;

		@GetMapping("/add")
		public String addProduct() {
			
			return "admin/admin_add";
		}
		
		@GetMapping("/list")
		public String listProduct(Model model) {
			Iterable<Admin> listOfAdmin = adminRepo.findAll();
			System.out.println(listOfAdmin.iterator());
			model.addAttribute("listOfAdmin", listOfAdmin);
			return "admin/admin_list";
		}

}
