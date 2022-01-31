package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.ProductService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.ProductDao;
import com.rzk.RitzyGoat.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {
		
		this.productDao = productDao;
		
	}

	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>(productDao.findAll(),"products are listed!");

	}

	@Override
	public Result add(Product product) {
		
		productDao.save(product);
		return new SuccessResult("added new product data!");
		
	}

	@Override
	public DataResult<Product> getByProductId(int productId) {

		return new SuccessDataResult<Product>(productDao.findById(productId), "datas are listed!");

	}

	@Override
	public DataResult<List<Product>> getByCategoryLevel1Id(int categoryLevel1Id) {
		return new SuccessDataResult<List<Product>>(productDao.findByCategoryLevel1Id(categoryLevel1Id),"products are listed!");

	}

	@Override
	public Result delete(Product product) {
		productDao.delete(product);
		return new SuccessResult("deleted selected product data!");
	}

	
	
	
	
}
