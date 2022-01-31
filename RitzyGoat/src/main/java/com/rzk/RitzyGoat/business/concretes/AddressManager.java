package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.AddressService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.AddressDao;
import com.rzk.RitzyGoat.entities.concretes.Address;

@Service
public class AddressManager implements AddressService {

	private AddressDao addressDao;

	@Autowired
	public AddressManager(AddressDao addressDao) {

		this.addressDao = addressDao;
	
	}

	@Override
	public DataResult<List<Address>> getAll() {
		
		return new SuccessDataResult<List<Address>>(addressDao.findAll(),"addresses are listed!");
		
	}

	@Override
	public Result add(Address address) {

		addressDao.save(address);
		return new SuccessResult("registration is successful!");

	}
	
	
	
}
