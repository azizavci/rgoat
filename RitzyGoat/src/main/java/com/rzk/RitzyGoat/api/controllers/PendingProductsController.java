package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.PendingProductService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.PendingProduct;

@RestController
@RequestMapping("/api/pendingProducts")
@CrossOrigin
public class PendingProductsController {

	private PendingProductService productService;

	@Autowired
	public PendingProductsController(PendingProductService productService) {

		this.productService = productService;
	
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody PendingProduct product) {
		
		return this.productService.add(product);
		
	}
	

	@GetMapping("/getAll")
	public DataResult<List<PendingProduct>> getAll(){
		
		return this.productService.getAll();
		
	}

	
	
	
}