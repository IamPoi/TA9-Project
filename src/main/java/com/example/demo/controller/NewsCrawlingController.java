package com.example.demo.controller;

import java.io.IOException;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class NewsCrawlingController {
	
	@GetMapping("/")
	public String newsCrawling() throws IOException, BadLocationException {
	
		System.out.println("뉴스 크롤링");
		
//		
//		String url = "https://news.naver.com/";
//		Document doc = (Document) Jsoup.connect(url).get();
//		System.out.println(doc.getText(0, 0));
		
		
		return "index";
	}
	

}
