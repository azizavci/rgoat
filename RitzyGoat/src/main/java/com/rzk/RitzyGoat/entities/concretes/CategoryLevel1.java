package com.rzk.RitzyGoat.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category_level_1")
public class CategoryLevel1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="category_name")
	private String categoryName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoryLevel1")
	private List<CategoryLevel2> categoryLevel2s;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoryLevel1")
	private List<Product> products;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoryLevel1")
	private List<PendingProduct> pendingProducts;
}
