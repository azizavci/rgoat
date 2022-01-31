package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.RatingService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.Rating;

@RestController
@RequestMapping("/api/ratings")

public class RatingsController {

	private RatingService ratingService;

	@Autowired
	public RatingsController(RatingService ratingService) {

		this.ratingService = ratingService;
	
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Rating rating) {
		
		return this.ratingService.add(rating);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Rating>> getAll(){
		
		return this.ratingService.getAll();
		
	}
	
	
}
