package com.rzk.RitzyGoat.business.abstracts;

import java.util.List;

import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.CategoryLevel1;

public interface CategoryLevel1Service {

	DataResult<List<CategoryLevel1>> getAll();
	Result add(CategoryLevel1 categoryLevel1);
	
	
	
	
}
