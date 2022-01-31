package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.CampaignService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.Campaign;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignsController {

	private CampaignService campaignService;

	@Autowired
	public CampaignsController(CampaignService campaignService) {
		
		this.campaignService = campaignService;

	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Campaign campaign) {
		
		return this.campaignService.add(campaign);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Campaign>> getAll(){
		
		return this.campaignService.getAll();
		
	}
	
	
}
