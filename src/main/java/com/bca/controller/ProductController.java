package com.bca.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bca.dto.ErrorMessage;
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
	public String save(@Valid ProductForm productForm, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttribute) {

		if (!bindingResult.hasErrors()) {
			// if(productService.findBy
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
			// return "admin/product_add";
		} else {
			ErrorMessage msg = new ErrorMessage();
			for (ObjectError err : bindingResult.getAllErrors()) {
				msg.getMessages().add(err.getDefaultMessage());
			}
			model.addAttribute("brands", brandService.findAll());
			model.addAttribute("productForm", productForm);
			model.addAttribute("ERROR", msg);
			return "admin/product_add";
		}
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
		form.setId(product.getId_product());
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
	public String update(@Valid ProductForm productForm, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttribute) {
		Product product = productService.findById(productForm.getId()).get();
		product.setId_product(productForm.getId());
		product.setType(productForm.getType());
		product.setPhoto(productForm.getPhoto());
		product.setDescrip(productForm.getDescrip());
		product.setColor(productForm.getColor());
		product.setPrice(productForm.getPrice());
		product.setStock(productForm.getStock());
		product.setSold(productForm.getSold());
		product.setBrand(brandService.findById(productForm.getBrandId()).get());
		System.out.println(product.getBrand().getName_brand());
		productService.save(product);
		return "redirect:/product/list";
	}

	@GetMapping(value = "/delete/{id}")
	public String remove(@PathVariable("id") int id_product) {
		productService.delete(id_product);
		return "redirect:/product/list";
	}
}
