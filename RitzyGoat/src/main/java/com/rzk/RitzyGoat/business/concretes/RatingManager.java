package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.RatingService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.RatingDao;
import com.rzk.RitzyGoat.entities.concretes.Rating;

@Service
public class RatingManager implements RatingService  {

	private RatingDao ratingDao;

	@Autowired
	public RatingManager(RatingDao ratingDao) {

		this.ratingDao = ratingDao;
	
	}

	@Override
	public DataResult<List<Rating>> getAll() {
		
		return new SuccessDataResult<List<Rating>>(ratingDao.findAll(), "ratings are listed!");
		
	}

	@Override
	public Result add(Rating rating) {

		ratingDao.save(rating);
		return new SuccessResult("added new rating data!");
		
	}
	
	
	
}
