package com.rzk.RitzyGoat.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.rzk.RitzyGoat.business.abstracts.ProductImageService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.ErrorResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.ProductDao;
import com.rzk.RitzyGoat.dataAccess.abstracts.ProductImageDao;
import com.rzk.RitzyGoat.entities.concretes.ProductImage;

@Service
public class ProductImageManager implements ProductImageService {

	private ProductImageDao productImageDao;
	private ProductDao productDao;

	@Autowired
	public ProductImageManager(ProductImageDao productImageDao, ProductDao productDao) {

		this.productImageDao = productImageDao;
		this.productDao = productDao;

	}

	@Override
	public Result upload(MultipartFile file, int productId) {

		ProductImage productImage = new ProductImage();

		try {
			productImage.setName(StringUtils.cleanPath(file.getOriginalFilename()));
			productImage.setContentType(file.getContentType());
			productImage.setProduct(productDao.getById(productId));
			productImage.setData(file.getBytes());
			productImage.setSize(file.getSize());

			this.productImageDao.save(productImage);

			return new SuccessResult("image uploaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ErrorResult("UserImageManager uploadResult null");

	}

	@Override
	public DataResult<List<ProductImage>> getByProductId(int productId) {

		return new SuccessDataResult<List<ProductImage>>(this.productImageDao.findByProductId(productId),
				"images listed!");

	}

	@Override
	public DataResult<List<ProductImage>> getAll() {

		return new SuccessDataResult<List<ProductImage>>(this.productImageDao.findAll(), "images listed!");

	}

	@Override
	public Optional<ProductImage> getById(String id) {
		return productImageDao.findById(id);
	}

	@Override
	public List<ProductImage> listById(int productId) {
		
		return productImageDao.findByProductId(productId);
	}

}
