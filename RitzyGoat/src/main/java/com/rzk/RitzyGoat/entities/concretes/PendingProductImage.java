package com.rzk.RitzyGoat.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="pending_product_images")
public class PendingProductImage {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	private String id;
	
	@Column(name="product_number")
	private String productNumber;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="content_type")
	private String contentType;
	
	@Lob
	@Column(name="data")
    private byte[] data;

	@Column(name="size")
	private Long size;

	@Column(name = "created_at")
	private LocalDate createdAt = LocalDate.now();
	
}
