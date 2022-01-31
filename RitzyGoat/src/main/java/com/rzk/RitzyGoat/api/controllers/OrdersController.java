package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.OrderService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.Order;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrdersController {

	private OrderService orderService;

	@Autowired
	public OrdersController(OrderService orderService) {

		this.orderService = orderService;
	
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Order order) {
		
		return this.orderService.add(order);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Order>> getAll(){
		
		return this.orderService.getAll();
		
	}
	
}
