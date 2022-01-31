package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.BasketService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.BasketDao;
import com.rzk.RitzyGoat.entities.concretes.Basket;

@Service
public class BasketManager implements BasketService{

	private BasketDao basketDao;

	@Autowired
	public BasketManager(BasketDao basketDao) {

		this.basketDao = basketDao;
	
	}

	@Override
	public DataResult<List<Basket>> getAll() {
		
		return new SuccessDataResult<List<Basket>>(basketDao.findAll(), "all baskets listed!");
		
	}

	@Override
	public Result add(Basket basket) {
		
		basketDao.save(basket);
		return new SuccessResult("added new basket");
		
	}
	
	
	
	
	
}
