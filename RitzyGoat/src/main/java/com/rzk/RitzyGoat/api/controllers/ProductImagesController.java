package com.rzk.RitzyGoat.api.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

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

import com.rzk.RitzyGoat.business.abstracts.ProductImageService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.core.utilities.results.ErrorResult;
import com.rzk.RitzyGoat.entities.concretes.ProductImage;
import com.rzk.RitzyGoat.entities.concretes.ProductImageResponse;

@RestController
@RequestMapping("/api/productImages")
@CrossOrigin
public class ProductImagesController {

	private ProductImageService productImageService;

	@Autowired
	public ProductImagesController(ProductImageService productImageService) {

		this.productImageService = productImageService;

	}

	@PostMapping("/upload")
	public Result productImageUpload(@RequestParam("files") MultipartFile[] files, @RequestParam int productId) {

		if (files == null || files.length == 0) {
			return new ErrorResult("error");
		} else {
			Arrays.asList(files).stream().forEach(file -> {
				productImageService.upload(file, productId);
			});
			return new SuccessResult("success");
		}

	}

	@GetMapping("/getById")
	public DataResult<List<ProductImage>> getById(@RequestParam(value = "productId") int productId) {
		return this.productImageService.getByProductId(productId);
	}

	@GetMapping("/getAll")
	public DataResult<List<ProductImage>> getAll() {
		return this.productImageService.getAll();
	}

	@GetMapping
	public List<ProductImageResponse> list() {
		return productImageService.getAll().getData().stream().map(this::mapToFileResponse)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/getByProductId")
	@Transactional(readOnly=true)
	public List<ProductImageResponse> listByProductId(@RequestParam int id) {
		return productImageService.getByProductId(id).getData().stream().map(this::mapToFileResponse)
				.collect(Collectors.toList());
	}

	private ProductImageResponse mapToFileResponse(ProductImage fileEntity) {
		String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/productImages/")
				.path(fileEntity.getId()).toUriString();
		ProductImageResponse fileResponse = new ProductImageResponse();
		fileResponse.setProductId(fileEntity.getProduct().getId());
		fileResponse.setId(fileEntity.getId());
		fileResponse.setName(fileEntity.getName());
		fileResponse.setContentType(fileEntity.getContentType());
		fileResponse.setSize(fileEntity.getSize());
		fileResponse.setImageUrl(downloadURL);

		return fileResponse;
	}
	
	


	@GetMapping("{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		Optional<ProductImage> fileEntityOptional = productImageService.getById(id);
		if (!fileEntityOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		ProductImage fileEntity = fileEntityOptional.get();
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
				.contentType(MediaType.valueOf(fileEntity.getContentType())).body(fileEntity.getData());
	}

}
