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
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="category_1_id")
	private CategoryLevel1 categoryLevel1;
	
	@ManyToOne()
	@JoinColumn(name="category_2_id")
	private CategoryLevel2 categoryLevel2;
	
	@ManyToOne()
	@JoinColumn(name="category_3_id")
	private CategoryLevel3 categoryLevel3;
	
	@ManyToOne()
	@JoinColumn(name="color_id")
	private Color color;
	
	@ManyToOne()
	@JoinColumn(name="size_id")
	private Size size;
	
	@ManyToOne()
	@JoinColumn(name="material_id")
	private Material material;
	
	@ManyToOne()
	@JoinColumn(name="gender_id")
	private Gender gender;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "unit_price")
	private float unitPrice;
	
	@Column(name = "promotional_price")
	private float promotionalPrice;
	
	@Column(name="description")
	private String description;
	
	@Column(name="detailed_information")
	private String detailedInformation;
	
	// lists
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<Rating> ratings;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<Basket> baskets;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<ProductImage> productImages;
	
}
