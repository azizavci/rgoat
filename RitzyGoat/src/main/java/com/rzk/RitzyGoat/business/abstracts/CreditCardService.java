package com.rzk.RitzyGoat.business.abstracts;

import java.util.List;

import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.CreditCard;

public interface CreditCardService {

	DataResult<List<CreditCard>> getAll();
	Result add(CreditCard creditCard);
	
}
