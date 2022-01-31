package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.PendingProductService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.PendingProductDao;
import com.rzk.RitzyGoat.entities.concretes.PendingProduct;

@Service
public class PendingProductManager implements PendingProductService {

	private PendingProductDao pendingProductDao;

	@Autowired
	public PendingProductManager(PendingProductDao pendingProductDao) {
		
		this.pendingProductDao = pendingProductDao;
		
	}

	@Override
	public DataResult<List<PendingProduct>> getAll() {
		
		return new SuccessDataResult<List<PendingProduct>>(pendingProductDao.findAll(),"products are listed!");

	}

	@Override
	public Result add(PendingProduct pendingProduct) {
		
		pendingProductDao.save(pendingProduct);
		return new SuccessResult("added new product data!");
		
	}
	
}
