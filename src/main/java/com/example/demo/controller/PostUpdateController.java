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

import com.example.demo.model.PostDTO;
import com.example.demo.service.PostDetailService;
import com.example.demo.service.PostUpdateService;

@Controller
@RequestMapping("/")
public class PostUpdateController {
	
	@Autowired
	private PostUpdateService pus;
	
	@Autowired
	private PostDetailService pds;
	
	@GetMapping("post_update")
	public String post_update(@RequestParam int no, Model model) {
		
		try {
			PostDTO dto = pds.postDetailView(no);
			
			model.addAttribute("post",dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "post_update";
	};
	
	@PostMapping("post_update_try")
	public String post_update_try(@RequestParam Map<String,Object> map, Model model,HttpSession session) {
		try {
			
			String content = (String)map.get("content");
			
			System.out.println(content);
			
			content = content.replace("<p>", "");
			
			content = content.replace("</p>", "");
			
			System.out.println(content);
			
			map.put("content",content);
			
			System.out.println(map.toString()); 
			
			System.out.println("??????????????"+map.get("no"));
			
			pus.postUpdate(map);
			
			System.out.println("수정시도");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/post";
	}
	
}
