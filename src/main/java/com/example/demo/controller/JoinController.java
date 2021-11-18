package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.JoinService;

@Controller
@RequestMapping("/")
public class JoinController {
	
	@Autowired
	private JoinService js;
	
	@GetMapping("/join_page")
	public String joinPage() {
		return "join";
	}
	
	@PostMapping("/join")
	public String join(@RequestParam Map<String, Object> map, Model model) {
		System.out.println("회원가입 시도");
		
//		System.out.println(map.);
		
		try {
			js.join(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "index";
	}
	
}
