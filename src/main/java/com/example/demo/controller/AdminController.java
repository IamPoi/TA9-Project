package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("admin")
	public String admin_page() {
		
		System.out.println("관리자 페이지");
		
		return "admin";
	}
//	
//	@GetMapping("admin/post_search")
//	public String admin_search() {
//		
//		return "admin_post_search";
//	}
//	
	
	@GetMapping("admin_post")
	public String adminPostView() throws Exception {
		
		System.out.println("관리자 게시글 페이지");
		
		return "admin_post_search";
		
	}
	


}
