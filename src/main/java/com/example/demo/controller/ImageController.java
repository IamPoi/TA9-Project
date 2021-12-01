package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/")
public class ImageController {

//	@ApiOperation(value = "피드 등록 ", notes = "성공시 200, 실패시 에러를 반환합니다. \n ")
	@PostMapping("image")
	public ResponseEntity<String> createFeed(@RequestParam("file") MultipartFile file) {
		// 시간과 originalFilename으로 매핑 시켜서 src 주소를 만들어 낸다.

		System.out.println("hihi");

		StringBuilder sb = new StringBuilder();

		// file image 가 없을 경우
		if (file.isEmpty()) {
			sb.append("none");
		} else {
			sb.append(file.getOriginalFilename());
		}

		if (!file.isEmpty()) {
			File dest = new File("C://images/" + sb.toString());
			try {
				file.transferTo(dest);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// db에 파일 위치랑 번호 등록
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
