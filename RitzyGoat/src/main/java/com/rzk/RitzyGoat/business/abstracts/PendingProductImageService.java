package com.rzk.RitzyGoat.business.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.PendingProductImage;

public interface PendingProductImageService {

	Result upload(MultipartFile file,String productNumber);
	DataResult<List<PendingProductImage>> getByProductNumber(String productNumber);
	Optional<PendingProductImage> getById(String id);
	List<PendingProductImage> listById(String productNumber);
	DataResult<List<PendingProductImage>> getAll();
	
}
