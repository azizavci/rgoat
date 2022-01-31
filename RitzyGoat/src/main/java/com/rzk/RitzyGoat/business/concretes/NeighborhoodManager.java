package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.NeighborhoodService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.NeighborhoodDao;
import com.rzk.RitzyGoat.entities.concretes.Neighborhood;

@Service
public class NeighborhoodManager implements NeighborhoodService {

	private NeighborhoodDao neighborhoodDao;
	
	@Autowired
	public NeighborhoodManager(NeighborhoodDao neighborhoodDao) {

		this.neighborhoodDao = neighborhoodDao;
	
	}

	@Override
	public DataResult<List<Neighborhood>> getAll() {
		
		return new SuccessDataResult<List<Neighborhood>>(neighborhoodDao.findAll(),"neigborhood are listed!");
		
	}

	@Override
	public Result add(Neighborhood neighborhood) {
		
		neighborhoodDao.save(neighborhood);
		return new SuccessResult("registration is successful!");
		
	}

}
