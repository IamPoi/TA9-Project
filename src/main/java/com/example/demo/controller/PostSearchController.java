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
import com.example.demo.service.PostSearchService;

@Controller
@RequestMapping("/")
public class PostSearchController {
	
	@Autowired
	private PostSearchService pss;
	
	@GetMapping("post_search")
	public String postSearch(@RequestParam Map<String, Object> map,Model model, HttpSession session) {
		
		try {
			UserDTO user = (UserDTO)session.getAttribute("user");
			
			Long dong_num = user.getDong_num();	
			
			System.out.println(map.toString());
			
			map.put("dong_num", dong_num);
			
			String search = (String)map.get("search");
			
			map.put("search", search);
			
			System.out.println(map.toString());
			
			ArrayList<PostDTO> post =(ArrayList<PostDTO>)pss.postSearch(map);
			
			model.addAttribute("post_list",post);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "???";
		
//		return "redirect:/post";
	}
	

}
