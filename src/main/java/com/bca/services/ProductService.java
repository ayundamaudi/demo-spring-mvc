package com.bca.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bca.entity.Product;
import com.bca.repo.ProductRepo;

@Service("productService")
@Transactional 
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public Product save(Product product) {
		return productRepo.save(product);
	}
	
	public Iterable<Product> findAll(){
		return productRepo.findAll();
	}
	
	public List<Product> findAll(int page){
		Pageable pageable = PageRequest.of(page,10);
		return productRepo.findAll(pageable).getContent();
	}
	
	public List<Product> findAllByType(String type, int page){
		Pageable pageable = PageRequest.of(page,10);
		return productRepo.findAllByType(type, pageable);
	}
	
	public Optional<Product> findById(int id_product){
		return productRepo.findById(id_product);
	}
	
	public boolean delete(int id_product) {
		productRepo.deleteById(id_product);
		return true;
	}
}
