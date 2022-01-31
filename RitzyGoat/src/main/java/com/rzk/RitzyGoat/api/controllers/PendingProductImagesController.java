package com.rzk.RitzyGoat.api.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rzk.RitzyGoat.business.abstracts.PendingProductImageService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.ErrorResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.entities.concretes.PendingProductImage;
import com.rzk.RitzyGoat.entities.concretes.PendingProductImageResponse;

@RestController
@RequestMapping("/api/pendingProductImages")
@CrossOrigin
public class PendingProductImagesController {

	private PendingProductImageService pendingProductImageService;

	@Autowired
	public PendingProductImagesController(PendingProductImageService pendingProductImageService) {

		this.pendingProductImageService = pendingProductImageService;
	
	}
	
	@PostMapping("/upload")
	public Result productImageUpload(@RequestParam("files") MultipartFile[] files, @RequestParam String productNumber) {

		if (files == null || files.length == 0) {
			return new ErrorResult("error");
		} else {
			Arrays.asList(files).stream().forEach(file -> {
				pendingProductImageService.upload(file, productNumber);
			});
			return new SuccessResult("success");
		}

	}
	
	@GetMapping("/getByProductNumber")
	public DataResult<List<PendingProductImage>> getById(@RequestParam(value = "productNumber") String productNumber) {
		return this.pendingProductImageService.getByProductNumber(productNumber);
	}

	@GetMapping("/getAll")
	public DataResult<List<PendingProductImage>> getAll() {
		return this.pendingProductImageService.getAll();
	}

	@GetMapping
	public List<PendingProductImageResponse> list() {
		return pendingProductImageService.getAll().getData().stream().map(this::mapToFileResponse)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/getByProductId")
	@Transactional(readOnly=true)
	public List<PendingProductImageResponse> listByProductNumber(@RequestParam String productNumber) {
		return pendingProductImageService.getByProductNumber(productNumber).getData().stream().map(this::mapToFileResponse)
				.collect(Collectors.toList());
	}

	private PendingProductImageResponse mapToFileResponse(PendingProductImage fileEntity) {
		String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/pendingProductImages/")
				.path(fileEntity.getId()).toUriString();
		PendingProductImageResponse fileResponse = new PendingProductImageResponse();
		fileResponse.setProductNumber(fileEntity.getProductNumber());
		fileResponse.setId(fileEntity.getId());
		fileResponse.setName(fileEntity.getName());
		fileResponse.setContentType(fileEntity.getContentType());
		fileResponse.setSize(fileEntity.getSize());
		fileResponse.setImageUrl(downloadURL);

		return fileResponse;
	}
	
	


	@GetMapping("{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		Optional<PendingProductImage> fileEntityOptional = pendingProductImageService.getById(id);
		if (!fileEntityOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		PendingProductImage fileEntity = fileEntityOptional.get();
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
				.contentType(MediaType.valueOf(fileEntity.getContentType())).body(fileEntity.getData());
	}

	
	
	
}
