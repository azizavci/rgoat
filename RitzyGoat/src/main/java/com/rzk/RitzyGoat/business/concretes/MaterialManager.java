package com.rzk.RitzyGoat.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.MaterialService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.MaterialDao;
import com.rzk.RitzyGoat.entities.concretes.Gender;
import com.rzk.RitzyGoat.entities.concretes.Material;



@Service
public class MaterialManager implements MaterialService {

	private MaterialDao materialDao;

	@Autowired
	public MaterialManager(MaterialDao materialDao) {
		super();
		this.materialDao = materialDao;
	}

	@Override
	public DataResult<List<Material>> getAll() {
		return new SuccessDataResult<List<Material>>(materialDao.findAll(),"materials are listed!");

	}

	@Override
	public Result add(Material material) {
		materialDao.save(material);
		return new SuccessResult("registration is successful!");
	}
	
	
	

	
}
