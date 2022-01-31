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

import com.rzk.RitzyGoat.business.abstracts.CategoryLevel2Service;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.CategoryLevel2;

@RestController
@RequestMapping("/api/categories/categoryLevel2")
@CrossOrigin

public class CategoryLevel2sController {

	private CategoryLevel2Service categoryLevel2Service;

	@Autowired
	public CategoryLevel2sController(CategoryLevel2Service categoryLevel2Service) {

		this.categoryLevel2Service = categoryLevel2Service;
	
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CategoryLevel2 categoryLevel2) {
		
		return this.categoryLevel2Service.add(categoryLevel2);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CategoryLevel2>> getAll(){
		
		return this.categoryLevel2Service.getAll();
		
	}
	
	@GetMapping("/getByCategoryLevel1Id")
	public DataResult<List<CategoryLevel2>> getByCategoryLevel1Id(@RequestParam int id){
		
		return this.categoryLevel2Service.getByCategoryLevel1Id(id);
		
	}
}
