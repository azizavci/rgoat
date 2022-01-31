package com.rzk.RitzyGoat.business.abstracts;

public interface QrService {

	byte[] generate(String text, int width, int height);
}
