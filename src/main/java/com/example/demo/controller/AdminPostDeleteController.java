package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.PostDeleteService;

@Controller
@RequestMapping("/")
public class AdminPostDeleteController {

	@Autowired
	private PostDeleteService pds;

	@GetMapping("admin_post_delete")
	public String postDelete(@RequestParam int no) {
		
		System.out.println("게시글 삭제 시도");
		
		try {
			pds.postDelete(no);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin_post_search?search=";
	}

}
