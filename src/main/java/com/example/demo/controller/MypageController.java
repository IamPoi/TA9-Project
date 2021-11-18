package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.UserDTO;

@Controller
@RequestMapping("/")
public class MypageController {
	
	@GetMapping("mypage")
	public String Mypage(HttpSession session,Model model) {
		System.out.println("mypage 접근");
		
		UserDTO dto = (UserDTO)session.getAttribute("user");
		
		
	
		System.out.println(dto.getId());
		
		
		return "mypage";
	}

}
