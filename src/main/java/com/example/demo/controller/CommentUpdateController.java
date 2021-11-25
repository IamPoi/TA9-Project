package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.CommentUpdateService;

@Controller
@RequestMapping("/")
public class CommentUpdateController {
	
	@Autowired
	private CommentUpdateService cus;
	
	@GetMapping("comment_update")
	public String comment_update(@RequestParam Map<String, Object> map, Model model) {
		
		int no = Integer.parseInt((String)map.get("no"));
		
		try {
			System.out.println("댓글 수정");
			cus.commentUpdate(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/post_detail?no="+no;
	}
		

}
