package com.rzk.RitzyGoat.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rzk.RitzyGoat.entities.concretes.CategoryLevel2;

public interface CategoryLevel2Dao extends JpaRepository<CategoryLevel2, Integer> {

	List<CategoryLevel2> findByCategoryLevel1Id(int categoryId);
	
}
