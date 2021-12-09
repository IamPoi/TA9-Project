package com.example.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.LocationDTO;
import com.example.demo.model.PostDTO;
import com.example.demo.model.UserDTO;
import com.example.demo.service.PostService;
import com.example.demo.service.UserLocationService;



@Controller
@RequestMapping("/")
public class PostController {
	
	@Autowired
	private PostService ps;
	
	@GetMapping("/post")
	public String postView(Model model, HttpSession session) {
		
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		
		System.out.println("게시판 목록");
		
		UserDTO dto =  (UserDTO)session.getAttribute("user");
		
		
		System.out.println(dto.getDong_num());
		
		Long dong_num = (Long)dto.getDong_num();
		
		
		System.out.println("dto = " + dto);
		
		try {
			
			ArrayList<PostDTO> post_list = ps.postView(dong_num);
			
			model.addAttribute("post_list",post_list);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "post";
	}

}
