package com.rzk.RitzyGoat.entities.concretes;

import lombok.Data;

@Data
public class ProductImageResponse {

	private String id;
	private int productId;
    private String name;
    private Long size;
    private String imageUrl;
    private String contentType;
    
    
	
}
