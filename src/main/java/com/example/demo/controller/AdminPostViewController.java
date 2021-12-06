package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.PostDTO;
import com.example.demo.service.AdminPostViewService;

@Controller
@RequestMapping("/")
public class AdminPostViewController {
	
	@Autowired
	private AdminPostViewService apvs;
	
	@GetMapping("admin_post_search")
	public String adminPostView(Model model,@RequestParam Map<String, Object> map)  {
		
		System.out.println(map.toString());
		
		System.out.println("관리자 게시글 조회 fxck");
		
		ArrayList<PostDTO> post_list;
		try {
			post_list = apvs.allPostView(map);
			System.out.println(post_list.toString());			
			model.addAttribute("post_list",post_list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "admin_post_search";
		
	}

}
