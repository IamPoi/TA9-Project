package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.PostDeleteService;

@Controller
@RequestMapping("/")
public class PostDeleteController {
	
	@Autowired
	private PostDeleteService pds;
	
	@GetMapping("post_delete")
	public String postDelete(@RequestParam int no) {
		
		try {
			pds.postDelete(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/post";
	}

}
