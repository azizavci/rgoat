package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.OrderDetailService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.OrderDetail;

@RestController
@RequestMapping("/api/orderDetails")
@CrossOrigin
public class OrderDetailsController {

	private OrderDetailService orderDetailService;

	@Autowired
	public OrderDetailsController(OrderDetailService orderDetailService) {

		this.orderDetailService = orderDetailService;
	
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody OrderDetail orderDetail) {
		
		return this.orderDetailService.add(orderDetail);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<OrderDetail>> getAll(){
		
		return this.orderDetailService.getAll();
		
	}
	
}
