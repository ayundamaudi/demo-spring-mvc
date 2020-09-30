package com.bca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bca.dto.ResponseData;
import com.bca.entity.Brand;
import com.bca.services.BrandService;

@RestController
@RequestMapping("/api/brands")
public class BrandApiController {

	@Autowired
	private BrandService brandService;
	
	@GetMapping
	public ResponseEntity<ResponseData> findAllBrand(){
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Brands found");
			response.setPayload(brandService.findAll());
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load Brands: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
	/*
	 * @PostMapping public ResponseEntity<ResponseData> saveCategory(@RequestBody
	 * CategoryForm form){ Brand brand = new Brand(); brand.setName(form.getName());
	 * ResponseData response = new ResponseData(); response.setStatus(true);
	 * response.setPayload(brandService.save(brand)); return
	 * ResponseEntity.ok(response); }
	 */
	
	/*
	 * @GetMapping public Iterable<Brand> findAllBrand(){ return
	 * brandService.findAll(); }
	 */
}
