package com.rzk.RitzyGoat.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rzk.RitzyGoat.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product,Integer> {

	Product findById(int productId);
	List<Product> findByCategoryLevel1Id(int categoryLevel1Id);
}
