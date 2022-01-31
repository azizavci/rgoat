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

import com.rzk.RitzyGoat.business.abstracts.CustomerService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.Customer;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomersController {

	private CustomerService customerService;

	@Autowired
	public CustomersController(CustomerService customerService) {
		this.customerService=customerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Customer>> getAll(){
		
		return customerService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Customer customer) {

		return customerService.add(customer);
	
	}
	
	@GetMapping("/getById")
	public DataResult<Customer> getById(@RequestParam Long id){
		
		return customerService.getById(id);
		
	}

	
	
	
}
