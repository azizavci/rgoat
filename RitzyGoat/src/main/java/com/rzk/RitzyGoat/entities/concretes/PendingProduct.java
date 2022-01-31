package com.rzk.RitzyGoat.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pending_products")
public class PendingProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne()
	@JoinColumn(name="category_1_id")
	private CategoryLevel1 categoryLevel1;
	
	@ManyToOne()
	@JoinColumn(name="category_2_id")
	private CategoryLevel2 categoryLevel2;
	
	@ManyToOne()
	@JoinColumn(name="category_3_id")
	private CategoryLevel3 categoryLevel3;
		
	@Column(name = "product_name")
	private String productName;
	
	@Column(name="detailed_information")
	private String detailedInformation;
	
	@Column(name="product_number")
	private String productNumber;
	
	@Column(name="uploading_date")
	private LocalDateTime uploadingDate = LocalDateTime.now();
	
	@Column(name="is_cancelled")
	private Boolean isCancelled;
	
	@Column(name="status")
	private Boolean status;
	
	
}
