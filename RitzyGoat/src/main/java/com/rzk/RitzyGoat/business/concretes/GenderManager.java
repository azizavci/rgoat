package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.GenderService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.GenderDao;
import com.rzk.RitzyGoat.entities.concretes.Gender;

@Service
public class GenderManager implements GenderService{
	
	private GenderDao genderDao;
	
	@Autowired
	public GenderManager(GenderDao genderDao) {
		super();
		this.genderDao = genderDao;
	}

	@Override
	public DataResult<List<Gender>> getAll() {
		return new SuccessDataResult<List<Gender>>(genderDao.findAll(),"genders are listed!");

	}

	@Override
	public Result add(Gender gender) {
		genderDao.save(gender);
		return new SuccessResult("registration is successful!");
	}

}
