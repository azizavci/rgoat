package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.CategoryLevel1Service;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.CategoryLevel1Dao;
import com.rzk.RitzyGoat.entities.concretes.CategoryLevel1;

@Service
public class CategoryLevel1Manager implements CategoryLevel1Service {

	private CategoryLevel1Dao categoryLevel1Dao;

	@Autowired
	public CategoryLevel1Manager(CategoryLevel1Dao categoryLevel1Dao) {

		this.categoryLevel1Dao = categoryLevel1Dao;

	}

	@Override
	public DataResult<List<CategoryLevel1>> getAll() {
		
		return new SuccessDataResult<List<CategoryLevel1>>(categoryLevel1Dao.findAll(),"all categories are listed!");
		
	}

	@Override
	public Result add(CategoryLevel1 categoryLevel1) {
		categoryLevel1Dao.save(categoryLevel1);
		return new SuccessResult("added new category!") ;
	
	}

	
	
}
