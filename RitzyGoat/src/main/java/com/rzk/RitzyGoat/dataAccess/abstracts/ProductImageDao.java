package com.rzk.RitzyGoat.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rzk.RitzyGoat.entities.concretes.ProductImage;

public interface ProductImageDao extends JpaRepository<ProductImage, String>{

	List<ProductImage> findByProductId(int productId);
	
}
