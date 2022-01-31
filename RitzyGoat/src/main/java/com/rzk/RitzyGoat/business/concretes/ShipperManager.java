package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.ShipperService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.ShipperDao;
import com.rzk.RitzyGoat.entities.concretes.Shipper;

@Service
public class ShipperManager implements ShipperService {

	private ShipperDao shipperDao;

	@Autowired
	public ShipperManager(ShipperDao shipperDao) {

		this.shipperDao = shipperDao;
	
	}

	@Override
	public DataResult<List<Shipper>> getAll() {
		
		return new SuccessDataResult<List<Shipper>>(shipperDao.findAll(), "all shippers listed!");
		
	}

	@Override
	public Result add(Shipper shipper) {
		
		shipperDao.save(shipper);
		return new SuccessResult("added new shipper");
		
	}
	
}
