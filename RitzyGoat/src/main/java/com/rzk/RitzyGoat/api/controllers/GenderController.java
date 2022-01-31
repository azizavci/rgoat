package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.GenderService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.Gender;

@RestController
@RequestMapping("/api/genders")
@CrossOrigin
public class GenderController {

	private GenderService genderService;

	@Autowired
	public GenderController(GenderService genderService) {
		super();
		this.genderService = genderService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Gender gender) {
		return this.genderService.add(gender);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Gender>> getAll(){
		
		return this.genderService.getAll();
		
	}
	
}
