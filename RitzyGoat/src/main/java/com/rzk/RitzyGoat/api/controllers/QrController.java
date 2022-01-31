package com.rzk.RitzyGoat.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.business.abstracts.QrService;

@RestController
public class QrController {

	private final int WIDTH = 250;
	  private final int HEIGHT = 250;
	  private final String QR_TEXT = "12345";

	  @Autowired 
	  private QrService qrCodeService;

	  @GetMapping("qr-code")
	  public ResponseEntity<byte[]> getQrCode() {

	    byte[] qrImage = qrCodeService.generate(QR_TEXT, WIDTH, HEIGHT);

	    return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrImage);
	  }
	
}
