package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.CreditCardService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.CreditCard;

@RestController
@RequestMapping("/api/payment")

public class CreditCardsController {

	private CreditCardService creditCardService;

	@Autowired
	public CreditCardsController(CreditCardService creditCardService) {
		this.creditCardService = creditCardService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreditCard creditCard) {
		
		return this.creditCardService.add(creditCard);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CreditCard>> getAll(){
		
		return this.creditCardService.getAll();
		
	}
	
	
	
	
}
