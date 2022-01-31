package com.rzk.RitzyGoat.core.imageUpload.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.rzk.RitzyGoat.core.utilities.results.DataResult;


public interface ImageUploadService {

	@SuppressWarnings("rawtypes")
	DataResult<Map> imageUpload(MultipartFile file);
	
}
