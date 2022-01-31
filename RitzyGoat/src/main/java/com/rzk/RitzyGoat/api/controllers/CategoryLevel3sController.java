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

import com.rzk.RitzyGoat.business.abstracts.CategoryLevel3Service;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.CategoryLevel3;

@RestController
@RequestMapping("/api/categories/categoryLevel3")
@CrossOrigin
public class CategoryLevel3sController {

	private CategoryLevel3Service categoryLevel3Service;

	@Autowired
	public CategoryLevel3sController(CategoryLevel3Service categoryLevel3Service) {

		this.categoryLevel3Service = categoryLevel3Service;
	
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CategoryLevel3 categoryLevel3) {
		
		return this.categoryLevel3Service.add(categoryLevel3);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CategoryLevel3>> getAll(){
		
		return this.categoryLevel3Service.getAll();
		
	}
	
	@GetMapping("/getByCategoryLevel2Id")
	public DataResult<List<CategoryLevel3>> getByCategoryLevel2Id(@RequestParam int id){
		
		return this.categoryLevel3Service.getByCategoryLevel2Id(id);
		
	}
	
}
