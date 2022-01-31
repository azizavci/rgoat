package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.SizeService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.Size;

@CrossOrigin
@RestController
@RequestMapping("/api/sizes")
public class SizesController {

	private SizeService sizeService;

	@Autowired
	public SizesController(SizeService sizeService) {
		this.sizeService = sizeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Size size) {
		
		return this.sizeService.add(size);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Size>> getAll(){
		
		return this.sizeService.getAll();
		
	}
	
	
}
