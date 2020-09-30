package com.bca.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bca.dto.ProductForm;
import com.bca.dto.ResponseData;
import com.bca.entity.Product;
import com.bca.services.BrandService;
import com.bca.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductApiController {

	@Autowired
	private BrandService brandService;

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<ResponseData> findAllProduct(){
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Products loaded");
			response.setPayload(productService.findAll());
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load products: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
	@GetMapping(value = "/{page}/{rows}")
	public ResponseEntity<ResponseData> findAllBookPerPage(@PathVariable("page") int page, 
			@PathVariable("rows") int rows){
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Books loaded");
			response.setPayload(productService.findAll(page, rows));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load books: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
	@PostMapping
	public ResponseEntity<ResponseData> saveProduct(@Valid @RequestBody ProductForm productForm, BindingResult errors){
		ResponseData response = new ResponseData();
		
		if(!errors.hasErrors()) {
			
/*			if(productService.findByCode(bookForm.getCode()) == null) {*/
				Product product= new Product();
				product.setType(productForm.getType());
				product.setPhoto(productForm.getPhoto());
				product.setDescrip(productForm.getDescrip());
				product.setColor(productForm.getColor());
				product.setPrice(productForm.getPrice());
				product.setStock(productForm.getStock());
				product.setSold(productForm.getSold());
				product.setBrand(brandService.findById(productForm.getBrandId()).get());
				response.setPayload(productService.save(product));				
				response.setStatus(true);
				response.getMessages().add("Product saved");
				return ResponseEntity.ok(response);
				/*
				 * }else { response.setStatus(false);
				 * response.getMessages().add("Please use another code"); return
				 * ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); }
				 */			
		}else {
			response.setStatus(false);
			for(ObjectError err: errors.getAllErrors()) {
				response.getMessages().add(err.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
}
