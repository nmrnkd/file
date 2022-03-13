package com.care.root.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.care.root.dto.ShoesDTO;

@Configuration
public class FileConfig {
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		
		//파일 업로드 최대 크기 지정
		mr.setMaxUploadSize(52428800); //50MB
		mr.setDefaultEncoding("utf-8");
		
		return mr;
	}
/*	
	//shoesDTO 빈 등록
	@Bean
	public ShoesDTO test() {
		return new ShoesDTO();
	}
*/	
}
