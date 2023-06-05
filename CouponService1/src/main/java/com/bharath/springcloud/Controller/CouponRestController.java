package com.bharath.springcloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.springcloud.model.Coupon;
import com.bharath.springcloud.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	
	@Autowired
	CouponRepo repo;
	@PostMapping("/coupons")
	public Coupon create(@RequestBody Coupon coupon) {
		return repo.save(coupon);
	}
	
	@GetMapping("/coupons/{code}")
	public ResponseEntity<Coupon> getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);
	}

}