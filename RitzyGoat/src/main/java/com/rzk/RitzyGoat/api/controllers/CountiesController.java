package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.CountyService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.County;

@RestController
@RequestMapping("/api/counties")
@CrossOrigin
public class CountiesController {

	private CountyService countyService;

	@Autowired
	public CountiesController(CountyService countyService) {

		this.countyService = countyService;
	
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody County county) {
		
		return this.countyService.add(county);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<County>> getAll(){
		
		return this.countyService.getAll();
		
	}
	
	
	
}
