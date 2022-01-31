package com.rzk.RitzyGoat.entities.concretes;

import lombok.Data;

@Data
public class PendingProductImageResponse {

	private String id;
	private String productNumber;
    private String name;
    private Long size;
    private String imageUrl;
    private String contentType;
    
	
}
