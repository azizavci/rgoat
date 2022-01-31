package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.ShipperService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.Shipper;

@RestController
@RequestMapping("/api/shippers")
@CrossOrigin
public class ShippersController {

	private ShipperService shipperService;

	@Autowired
	public ShippersController(ShipperService shipperService) {

		this.shipperService = shipperService;
	
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Shipper Shipper) {
		
		return this.shipperService.add(Shipper);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Shipper>> getAll(){
		
		return this.shipperService.getAll();
		
	}
	
}
