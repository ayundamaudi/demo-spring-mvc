package com.bca.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.bca.entity.Product;

public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.type LIKE :type")
	public List<Product> findAllByType(@Param("type") String Type, Pageable pageable);
	
	//kata bapak kalau byid sudah tersedia secara default jadi gak perlu
	//save delete update findAll juga	
//	public Product findById(int id_product);
	
//	public List<Product> findByBrandId(int id_brand);
	
//	@Query("SELECT b FROM Product b WHERE b.name_brand = :name_brand")
//	public Product findByName_brand(@Param("name_brand") String name_brand);

}
