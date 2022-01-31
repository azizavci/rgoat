package com.rzk.RitzyGoat.business.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.ProductImage;

public interface ProductImageService {

	Result upload(MultipartFile file,int productId);
	DataResult<List<ProductImage>> getByProductId(int productId);
	Optional<ProductImage> getById(String id);
	List<ProductImage> listById(int productId);
	DataResult<List<ProductImage>> getAll();
	
	
	
}
