package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.CategoryLevel1Service;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.CategoryLevel1;


@RestController
@RequestMapping("/api/categories/categoryLevel1")
@CrossOrigin
public class CategoryLevel1sController {

	private CategoryLevel1Service categoryLevel1Service;

	@Autowired
	public CategoryLevel1sController(CategoryLevel1Service categoryLevel1Service) {

		this.categoryLevel1Service = categoryLevel1Service;
	
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CategoryLevel1 categoryLevel1) {
		
		return this.categoryLevel1Service.add(categoryLevel1);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CategoryLevel1>> getAll(){
		
		return this.categoryLevel1Service.getAll();
		
	}
	
	
	
	
}
