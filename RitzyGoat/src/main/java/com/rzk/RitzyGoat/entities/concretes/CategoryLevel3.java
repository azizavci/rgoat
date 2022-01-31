package com.rzk.RitzyGoat.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "category_level_3")
public class CategoryLevel3 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="category_level_2_id")
	private CategoryLevel2 categoryLevel2;
	
	@Column(name="category_name")
	private String categoryName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoryLevel3")
	private List<Product> products;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoryLevel3")
	private List<PendingProduct> pendingProducts;
	
}
