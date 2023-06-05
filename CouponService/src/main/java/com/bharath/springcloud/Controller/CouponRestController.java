package com.bharath.springcloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class CouponRestController {
	
	@Autowired
	CouponRepo repo;
	@PostMapping("/coupons")
	@PreAuthorize("hasRole('ADMIN')")
	public Coupon create(@RequestBody Coupon coupon) {
		return repo.save(coupon);
	}
	
	
	@GetMapping("/coupons/{code}")
	//@PostAuthorize("returnObject.discount<60")
	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);

	}
	
	
	
}
