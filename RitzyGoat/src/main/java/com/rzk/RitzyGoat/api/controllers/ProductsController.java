package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.ProductService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {

		this.productService = productService;
	
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		
		return this.productService.add(product);
		
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Product product) {
		
		return this.productService.delete(product);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Product>> getAll(){
		
		return this.productService.getAll();
		
	}
	
	@GetMapping("/getByProductId")
	public DataResult<Product> getByProductId(@RequestParam int id){
		
		return this.productService.getByProductId(id);
		
	}
	
	@GetMapping("/getByCategory1Id")
	public DataResult<List<Product>> getByCategoryLevel1Id(@RequestParam int id){
		
		return this.productService.getByCategoryLevel1Id(id);
		
	}
	
	
	
	
}
