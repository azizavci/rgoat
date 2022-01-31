package com.rzk.RitzyGoat.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.rzk.RitzyGoat.business.abstracts.PendingProductImageService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.ErrorResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.PendingProductImageDao;
import com.rzk.RitzyGoat.entities.concretes.PendingProductImage;

@Service
public class PendingProductImageManager implements PendingProductImageService {

	private PendingProductImageDao pendingProductImageDao;

	@Autowired
	public PendingProductImageManager(PendingProductImageDao pendingProductImageDao) {
		this.pendingProductImageDao = pendingProductImageDao;
	}

	@Override
	public Result upload(MultipartFile file, String productNumber) {

		PendingProductImage productImage = new PendingProductImage();

		try {
			productImage.setName(StringUtils.cleanPath(file.getOriginalFilename()));
			productImage.setContentType(file.getContentType());
			productImage.setProductNumber(productNumber);
			productImage.setData(file.getBytes());
			productImage.setSize(file.getSize());

			this.pendingProductImageDao.save(productImage);

			return new SuccessResult("image uploaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ErrorResult("UserImageManager uploadResult null");

	}

	@Override
	public DataResult<List<PendingProductImage>> getByProductNumber(String productNumber) {
		return new SuccessDataResult<List<PendingProductImage>>(
				this.pendingProductImageDao.findByProductNumber(productNumber), "images listed!");
	}

	@Override
	public Optional<PendingProductImage> getById(String id) {

		return pendingProductImageDao.findById(id);

	}

	@Override
	public List<PendingProductImage> listById(String productNumber) {
		return pendingProductImageDao.findByProductNumber(productNumber);
	}

	@Override
	public DataResult<List<PendingProductImage>> getAll() {

		return new SuccessDataResult<List<PendingProductImage>>(this.pendingProductImageDao.findAll(),
				"images listed!");

	}

}
