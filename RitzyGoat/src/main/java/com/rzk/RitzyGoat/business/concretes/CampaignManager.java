package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.CampaignService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.CampaignDao;
import com.rzk.RitzyGoat.entities.concretes.Campaign;

@Service
public class CampaignManager implements CampaignService {

	private CampaignDao campaignDao;

	@Autowired
	public CampaignManager(CampaignDao campaignDao) {

		this.campaignDao = campaignDao;
	
	}

	@Override
	public DataResult<List<Campaign>> getAll() {
		
		return new SuccessDataResult<List<Campaign>>(campaignDao.findAll(),"campaigns are listed!");	
		
	}

	@Override
	public Result add(Campaign campaign) {
		
		campaignDao.save(campaign);
		return new SuccessResult("added new campaign data!");
		
	}
	
	
	
	
}
