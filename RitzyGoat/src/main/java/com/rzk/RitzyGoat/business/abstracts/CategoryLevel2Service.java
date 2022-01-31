package com.rzk.RitzyGoat.business.abstracts;

import java.util.List;

import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.CategoryLevel2;

public interface CategoryLevel2Service {

	DataResult<List<CategoryLevel2>> getAll();
	Result add(CategoryLevel2 categoryLevel2);
	
	DataResult<List<CategoryLevel2>> getByCategoryLevel1Id(int categoryId);

}
