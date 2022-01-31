package com.rzk.RitzyGoat.business.concretes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.QrService;

import net.glxn.qrgen.javase.QRCode;

@Service
public class QrManager implements QrService {

	@Override
	public byte[] generate(String text, int width, int height) {

		try (ByteArrayOutputStream bos = QRCode.from(text).withSize(width, height).stream();) {

			return bos.toByteArray();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}