package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.CategoryLevel3Service;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.CategoryLevel3Dao;
import com.rzk.RitzyGoat.entities.concretes.CategoryLevel3;

@Service
public class CategoryLevel3Manager implements CategoryLevel3Service{

	private CategoryLevel3Dao categoryLevel3Dao;

	@Autowired
	public CategoryLevel3Manager(CategoryLevel3Dao categoryLevel3Dao) {

		this.categoryLevel3Dao = categoryLevel3Dao;

	}

	@Override
	public DataResult<List<CategoryLevel3>> getAll() {
		
		return new SuccessDataResult<List<CategoryLevel3>>(categoryLevel3Dao.findAll(),"all categories are listed!");
		
	}

	@Override
	public Result add(CategoryLevel3 categoryLevel3) {
		categoryLevel3Dao.save(categoryLevel3);
		return new SuccessResult("added new category!") ;
	
	}

	@Override
	public DataResult<List<CategoryLevel3>> getByCategoryLevel2Id(int categoryId) {
		
		return new SuccessDataResult<List<CategoryLevel3>>(categoryLevel3Dao.findByCategoryLevel2Id(categoryId), "datas are listed!");

		
	}
	
}
