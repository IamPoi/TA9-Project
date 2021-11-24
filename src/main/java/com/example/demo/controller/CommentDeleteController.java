package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.CommentDeleteService;

@Controller
@RequestMapping("/")
public class CommentDeleteController {
	
	@Autowired
	private CommentDeleteService cds;
	
	@GetMapping("comment_delete")
	public String commentDelete(@RequestParam Map<String, Object> map) {
		
		int comment_num =   Integer.parseInt((String)map.get("comment_num"));   
		
		try {
			cds.commentDelete(comment_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/post_detail?no="+map.get("no");
	}

}
