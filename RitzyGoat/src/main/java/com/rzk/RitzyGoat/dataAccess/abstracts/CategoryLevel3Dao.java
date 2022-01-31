package com.rzk.RitzyGoat.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rzk.RitzyGoat.entities.concretes.CategoryLevel3;

public interface CategoryLevel3Dao extends JpaRepository<CategoryLevel3, Integer> {

	List<CategoryLevel3> findByCategoryLevel2Id(int categoryId);
	
}
