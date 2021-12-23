package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.AptDetailService;

@Controller
public class AptDetailController {
	@Autowired
	private AptDetailService ads;
	
	@GetMapping("apt_detail")
	public String apt_detail(@RequestParam Map<String, Object> map,Model model) {
		
		System.out.println(map.toString());
		
		try {
			model.addAttribute("apt_detail",ads.aptDetailView(map));
			
			System.out.println(ads.aptDetailView(map));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
		
		System.out.println("아파트 자세히 보기");
		
		return "apt_detail";
	}

}
