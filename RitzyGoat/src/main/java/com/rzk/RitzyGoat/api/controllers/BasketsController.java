package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.BasketService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.Basket;

@RestController
@RequestMapping("/api/baskets")
@CrossOrigin
public class BasketsController {

	private BasketService basketService;

	@Autowired
	public BasketsController(BasketService basketService) {

		this.basketService = basketService;
	
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Basket basket) {
		
		return this.basketService.add(basket);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Basket>> getAll(){
		
		return this.basketService.getAll();
		
	}
	
}
