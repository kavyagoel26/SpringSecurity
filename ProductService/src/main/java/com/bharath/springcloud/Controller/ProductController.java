package com.bharath.springcloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bharath.springcloud.model.Product;
import com.bharath.springcloud.repos.ProductRepo;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepo repo;
//	
//	@GetMapping("/")
//	public String index() {
//		return "index";
//	}
	
	@GetMapping("/showListNewProduct")
	public String showListNewProduct() {
		return "listNewProduct";
	}
	
	@PostMapping("/saveProduct")
	public String save(Product product) {
		repo.save(product);
		return "createResponse";
	}
	
	@GetMapping("/showGetProduct")
	public String showGetProduct() {
		return "getProduct";
	}
	
	@PostMapping("/getProduct")
	public ModelAndView getProduct(Long id) {
		ModelAndView mav = new ModelAndView("productDetails");
		mav.addObject(ProductRepo.findByid(id));
		return mav;
	}
	

}
