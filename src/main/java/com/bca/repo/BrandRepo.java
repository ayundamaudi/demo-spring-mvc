package com.bca.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.bca.entity.Brand;
import com.bca.entity.Product;

public interface BrandRepo extends JpaRepository<Brand, Integer> {

}
