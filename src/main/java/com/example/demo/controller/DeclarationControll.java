package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserDTO;
import com.example.demo.service.DeclarationService;

@Controller
@RequestMapping("/")
public class DeclarationControll {
	
	@Autowired
	private DeclarationService ds;
	
	@GetMapping("declaration")
	public String declartion(@RequestParam Map<String, Object> map, HttpSession session) {
		
		System.out.println("신고 접수");
		
		UserDTO dto = (UserDTO) session.getAttribute("user");
		
		map.put("user", dto.getId());
		
		try {
			ds.declaration(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/post_detail?no="+map.get("no");
				
	}

}
