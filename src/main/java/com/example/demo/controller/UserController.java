package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserDTO;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@GetMapping("/login_page")
	public String login() {
		System.out.println("로그인??");
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		System.out.println("로그인 시도");
		try {
			
			 UserDTO user = us.login(map);
			 if(user != null) {
				 session.setAttribute("user", user);
			 } else {
				 System.out.println("아이디 또는 비밀번호 확인");
				 return "error";
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
}
