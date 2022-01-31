package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.ColorService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.Color;

@RestController
@RequestMapping("/api/colors")
@CrossOrigin
public class ColorController {

	private ColorService colorService;
	
	@Autowired
	public ColorController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Color color) {
		return this.colorService.add(color);

	}
	@GetMapping("/getAll")
	public DataResult<List<Color>> getAll(){
		
		return this.colorService.getAll();
		
	}
}
