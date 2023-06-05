package com.bharath.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bharath.springcloud.model.Coupon;
@Repository
public interface CouponRepo extends JpaRepository<Coupon, Long> {



	Coupon findByCode(String code);

	//List<Coupon> findByCode(String code);

	
	

}
