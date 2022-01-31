package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.TypeOfAddressService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.TypeOfAddressDao;
import com.rzk.RitzyGoat.entities.concretes.TypeOfAddress;

@Service
public class AddressTypeManager implements TypeOfAddressService {

	private TypeOfAddressDao typeOfAddressDao;

	@Autowired
	public AddressTypeManager(TypeOfAddressDao typeOfAddressDao) {

		this.typeOfAddressDao = typeOfAddressDao;
	
	}

	@Override
	public DataResult<List<TypeOfAddress>> getAll() {
		
		return new SuccessDataResult<List<TypeOfAddress>>(typeOfAddressDao.findAll(),"address types are listed!");
		
	}

	@Override
	public Result add(TypeOfAddress typeOfAddress) {
		
		typeOfAddressDao.save(typeOfAddress);
		return new SuccessResult("registration is successful!");
		
	}
	
	
	
	
	
}
