package com.kgisl.ocr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kgisl.ocr.dao.ImageDao;

@SpringBootApplication
public class WebApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebApplication.class, args);
	}

	@Bean
	public ImageDao imageDao() {
		return new ImageDao();
	}
}
