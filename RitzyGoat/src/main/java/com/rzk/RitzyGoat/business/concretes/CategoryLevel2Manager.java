package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.CategoryLevel2Service;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.CategoryLevel2Dao;
import com.rzk.RitzyGoat.entities.concretes.CategoryLevel2;

@Service
public class CategoryLevel2Manager implements CategoryLevel2Service {

	private CategoryLevel2Dao categoryLevel2Dao;

	@Autowired
	public CategoryLevel2Manager(CategoryLevel2Dao categoryLevel2Dao) {

		this.categoryLevel2Dao = categoryLevel2Dao;

	}

	@Override
	public DataResult<List<CategoryLevel2>> getAll() {
		
		return new SuccessDataResult<List<CategoryLevel2>>(categoryLevel2Dao.findAll(),"all categories are listed!");
		
	}

	@Override
	public Result add(CategoryLevel2 categoryLevel2) {
		categoryLevel2Dao.save(categoryLevel2);
		return new SuccessResult("added new category!") ;
	
	}
	
	@Override
	public DataResult<List<CategoryLevel2>> getByCategoryLevel1Id(int categoryId) {
		
		return new SuccessDataResult<List<CategoryLevel2>>(categoryLevel2Dao.findByCategoryLevel1Id(categoryId), "datas are listed!");
		
	}
	
}
