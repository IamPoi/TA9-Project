package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.PostDTO;
import com.example.demo.service.PostDetailService;

@Controller
@RequestMapping("")
public class PostDetailController {
	
	@Autowired
	private PostDetailService pds;
	
	@GetMapping("post_detail")
	public String postDetailView(@RequestParam int no, Model model) {
		
		
		
//		int post_num = 
		
		System.out.println("게시판 자세히 보기");
		
		try {
			PostDTO dto =  pds.postDetailView(no);
			
			model.addAttribute("post_detail",dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "post_detail";
	}

}
