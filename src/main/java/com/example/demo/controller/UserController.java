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
	
	@GetMapping(value ="/login")
	public String login() {
		System.out.println("로그인??");
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		System.out.println("로그인 시도");
		try {
			if(map.get("userid") == null || map.get("userpw") == null){
				model.addAttribute("msg","아이디 비밀번호 입력");
				model.addAttribute("userid", map.get("userid"));
				model.addAttribute("userpw", map.get("userpw"));
				return "error";
			}
			 UserDTO user = us.login(map);
//			 UserDTO user = null;
			 if(user != null) {
				 session.setAttribute("user", user);
			 } else {
				 model.addAttribute("msg","아이디 비밀번호 다시");
				 model.addAttribute("userid", map.get("userid"));
				 model.addAttribute("userpw", map.get("userpw"));
				 return "error";
			 }
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg","로그인 중 문제 발생");
			return "error";
		}
		return "index";
	}
	
}
