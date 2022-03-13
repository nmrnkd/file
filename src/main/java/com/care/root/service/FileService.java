package com.care.root.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	public static final String IMAGE_REPO = "C:/Users/SSD/spring/image_repo"; 	//파일 저장소
	public void fileProcess(MultipartHttpServletRequest mul);
	public void getData(Model model);
}
