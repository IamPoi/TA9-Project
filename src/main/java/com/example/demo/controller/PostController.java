package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.PostDTO;
import com.example.demo.model.UserDTO;
import com.example.demo.service.PostService;



@Controller
@RequestMapping("/")
public class PostController {
	
	@Autowired
	private PostService ps;
	
//	@GetMapping(value ="/post")
//	public String post() {
//		System.out.println("게시판 목록1");
//		return "post";
//	}
	
	@GetMapping("/post")
	public String postView(Model model, HttpSession session) {
		
		
		System.out.println("게시판 목록2");
		
		UserDTO dto =  (UserDTO)session.getAttribute("user");
		
		System.out.println(dto.getDong_num());
		
		int dong_num = (int)dto.getDong_num();
		
		
		
		try {
			System.out.println("postcontroller post section1");
			
			ArrayList<PostDTO> post_list = ps.postView(dong_num);
			
			
			System.out.println("postlist : "+post_list.toString());
			
			System.out.println("postcontroller post section2");
			
			model.addAttribute("post_list",post_list);
			
			model.addAttribute("dong_num",dong_num);
			
			
		} catch (Exception e) {
			System.out.println("?????");
		}
		return "post";
	}

}
