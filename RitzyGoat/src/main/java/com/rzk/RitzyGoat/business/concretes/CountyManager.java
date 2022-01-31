package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.CountyService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.CountyDao;
import com.rzk.RitzyGoat.entities.concretes.County;

@Service
public class CountyManager implements CountyService {

	private CountyDao countyDao;

	@Autowired
	public CountyManager(CountyDao countyDao) {

		this.countyDao = countyDao;
		
	}

	@Override
	public DataResult<List<County>> getAll() {
		
		return new SuccessDataResult<List<County>>(countyDao.findAll(),"counties are listed!");
		
	}

	@Override
	public Result add(County county) {
		
		countyDao.save(county);
		return new SuccessResult("registration is successful!");
		
	}
	
	
	
}
