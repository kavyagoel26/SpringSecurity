package com.bharath.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

	static Product findByid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
		
		

}


