package com.bca.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bca.entity.Brand;
import com.bca.repo.BrandRepo;

@Service("brandService")
@Transactional 
public class BrandService {

	@Autowired
	private BrandRepo brandRepo;
	
	public Brand save(Brand brand) {
		return brandRepo.save(brand);
	}
	
	public Optional<Brand> findById(int id_brand){
		return brandRepo.findById(id_brand);
	}

	public Iterable<Brand> findAll(){
		return brandRepo.findAll();
	}
	
}
