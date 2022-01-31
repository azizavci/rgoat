package com.rzk.RitzyGoat.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rzk.RitzyGoat.entities.concretes.PendingProduct;

public interface PendingProductDao extends JpaRepository<PendingProduct, Long> {

	PendingProduct findByProductNumber(String productNumber);
	
}
