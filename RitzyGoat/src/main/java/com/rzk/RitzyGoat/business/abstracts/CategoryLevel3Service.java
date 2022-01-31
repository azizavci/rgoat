package com.rzk.RitzyGoat.business.abstracts;

import java.util.List;

import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.CategoryLevel3;

public interface CategoryLevel3Service {

	DataResult<List<CategoryLevel3>> getAll();
	Result add(CategoryLevel3 categoryLevel3);
	
	DataResult<List<CategoryLevel3>> getByCategoryLevel2Id(int categoryId);

	
}
