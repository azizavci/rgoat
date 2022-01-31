package com.rzk.RitzyGoat.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rzk.RitzyGoat.entities.concretes.PendingProductImage;

public interface PendingProductImageDao extends JpaRepository<PendingProductImage, String> {

	List<PendingProductImage> findByProductNumber(String productNumber);
}
