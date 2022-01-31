package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.CityService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.CityDao;
import com.rzk.RitzyGoat.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {

		this.cityDao = cityDao;
	
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(cityDao.findAll(),"cities are listed!");
	
	}

	@Override
	public Result add(City city) {
		
		cityDao.save(city);
		return new SuccessResult("registration is successful!");		
		
	}
	
	
	
	
	
}