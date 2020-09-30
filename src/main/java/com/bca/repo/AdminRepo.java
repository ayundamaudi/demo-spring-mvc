package com.bca.repo;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.bca.entity.Admin;

public interface AdminRepo extends PagingAndSortingRepository<Admin, Integer> {
	


}
