package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.SizeService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.SizeDao;
import com.rzk.RitzyGoat.entities.concretes.Size;

@Service
public class SizeManager implements SizeService {

	private SizeDao sizeDao;

	@Autowired
	public SizeManager(SizeDao sizeDao) {
		
		this.sizeDao = sizeDao;
		
	}

	@Override
	public DataResult<List<Size>> getAll() {

		return new SuccessDataResult<List<Size>>(sizeDao.findAll(),"sizes are listed!");

	}

	@Override
	public Result add(Size size) {

		sizeDao.save(size);
		return new SuccessResult("added new size data!");	
		
	}
	
	
	
}
