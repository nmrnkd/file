package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.service.FileService;

@Controller
public class FileController {
	@Autowired FileService fs;
	
	@GetMapping("form")
	public String form() {
		return "uploadForm";
	}
	@PostMapping("upload")
	public String upload(MultipartHttpServletRequest mul) {
		//enctype="multipart/form-data"을 사용하면 MultipartHttpServletRequest로만 받을 수 있음 
/*
		System.out.println(mul.getParameter("id"));
		System.out.println(mul.getParameter("name"));
		
		//파일명 출력
		MultipartFile file = mul.getFile("file");
		System.out.println(file.getOriginalFilename());
*/		
		fs.fileProcess(mul);
		return "redirect:form";
	}
	@GetMapping("views")
	public String views(Model model) {
		fs.getData(model);
		return "result";
	}
	@GetMapping("download")
	public void download(@RequestParam("file") String fileName,
							HttpServletResponse response) throws IOException {
		//content-disposition : 파일로 응답함
		//attachment : 웹 브라우저로 파일을 표현
		//fileName : 다운로드할 이름
		response.addHeader("content-disposition",
						"attachment; fileName="+fileName);
		//경로 설정
		File file = new File(FileService.IMAGE_REPO + "/" + fileName);
		FileInputStream fis = new FileInputStream(file);

		//inputstream을 통해 가져온 파일을 outstream으로 쏴줌 : read write를 같이 해줌.
		FileCopyUtils.copy(fis, response.getOutputStream());
		fis.close();
	}
}
