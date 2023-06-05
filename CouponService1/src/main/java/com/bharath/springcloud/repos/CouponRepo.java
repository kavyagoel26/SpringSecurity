package com.bharath.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.bharath.springcloud.model.Coupon;
@Repository
public interface CouponRepo extends JpaRepository<Coupon, Long> {

	ResponseEntity<Coupon> findByCode(String code);

	
	

}
