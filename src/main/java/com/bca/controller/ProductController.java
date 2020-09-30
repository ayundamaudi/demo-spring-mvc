package com.bca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bca.dto.ProductForm;
import com.bca.entity.Product;
import com.bca.repo.ProductRepo;
import com.bca.services.BrandService;
import com.bca.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private BrandService brandService;

	@Autowired
	private ProductService productService;

	@GetMapping("/add")
	public String addProduct(Model model) {
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("productForm", new ProductForm());
		return "admin/product_add";
	}

	@PostMapping("/add")
	public String save(ProductForm productForm, Model model) {
//		if(productService.findBy
		Product product = new Product();
		product.setType(productForm.getType());
		product.setPhoto(productForm.getPhoto());
		product.setDescrip(productForm.getDescrip());
		product.setColor(productForm.getColor());
		product.setPrice(productForm.getPrice());
		product.setStock(productForm.getStock());
		product.setSold(productForm.getSold());
		product.setBrand(brandService.findById(productForm.getBrandId()).get());
		productService.save(product);
		return "redirect:/product/list";
//		return "admin/product_add";
	}

	@GetMapping("/list")
	public String listProduct(Model model) {
		Iterable<Product> listOfProduct = productRepo.findAll();
//		System.out.println(listOfProduct.iterator());
		model.addAttribute("listOfProduct", listOfProduct);
		return "admin/product_list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id_product, Model model) {
		Product product = productService.findById(id_product).get();
		model.addAttribute("brands", brandService.findAll());
		ProductForm form = new ProductForm();
		form.setType(product.getType());
		form.setPhoto(product.getPhoto());
		form.setDescrip(product.getDescrip());
		form.setColor(product.getColor());
		form.setPrice(product.getPrice());
		form.setStock(product.getStock());
		form.setSold(product.getSold());
		form.setBrandId(product.getBrand().getId_brand());
		model.addAttribute("productForm", form);
		return "admin/product_edit";
	}

	@PostMapping("/update")
	public String update() {
		return "admin/product_add";
	}

	@GetMapping(value = "/delete/{id}")
	public String remove(@PathVariable("id") int id_product) {
		productService.delete(id_product);
		return "redirect:/product/list";
	}
}
