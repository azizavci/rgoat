package com.rzk.RitzyGoat.business.abstracts;

import java.util.List;

import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.Product;

public interface ProductService {

	DataResult<List<Product>> getAll();
	Result add(Product product);
	Result delete(Product product);
	
	DataResult<Product> getByProductId(int productId);
	DataResult<List<Product>> getByCategoryLevel1Id(int categoryLevel1Id);


	
}
