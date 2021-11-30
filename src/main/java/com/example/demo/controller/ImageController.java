package com.example.demo.controller;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@RequestMapping
public class ImageController {
	
	ServletContext servletContext;
	
	@ResponseBody
	@PostMapping
	public Map<String, Object> uploadImage(@RequestParam Map<String, Object> paramMap, MultipartRequest request, ) throws Exception
	{
		MultipartFile uploadFile = request.getFile("upload");
		String uploadDir = servletContext.getRealPath("/").replace("\\", "/") + "/static/upload/images/";
		String uploadId = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		uploadFile.transferTo(new File(uploadDir + uploadId));
		paramMap.put("url", "/static/upload/images/" + uploadId);
		return paramMap;
	}

}
