package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.RgPaymentService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.RgPaymentDao;
import com.rzk.RitzyGoat.entities.concretes.RGPayment;

@Service
public class RgPaymentManager implements RgPaymentService{

	private RgPaymentDao rgPaymentDao;

	@Autowired
	public RgPaymentManager(RgPaymentDao rgPaymentDao) {

		this.rgPaymentDao = rgPaymentDao;
	
	}

	@Override
	public DataResult<List<RGPayment>> getAll() {
		
		return new SuccessDataResult<List<RGPayment>>(rgPaymentDao.findAll(), "all payments listed!");
		
	}

	@Override
	public Result add(RGPayment rgPayment) {
		
		rgPaymentDao.save(rgPayment);
		return new SuccessResult("added new payment");
		
	}

	
}
