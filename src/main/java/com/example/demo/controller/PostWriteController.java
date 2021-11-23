package com.example.demo.controller;

import java.util.ArrayList;
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
import com.example.demo.model.UserDTO;
import com.example.demo.service.PostService;
import com.example.demo.service.PostWriteService;

@Controller
@RequestMapping
public class PostWriteController {
	
	@Autowired
	private PostService ps;
	
	@Autowired
	private PostWriteService pws;

	@GetMapping("post_write")
	public String post_write() {
		return "post_write";
	}
	
	@PostMapping("post_enrollment")
	public String post_enrollement(@RequestParam Map<String,Object> map,Model model,HttpSession session) {
		
		UserDTO dto =  (UserDTO)session.getAttribute("user");
		System.out.println("게시글 등록 시도");
		map.put("dong_num", dto.getDong_num());
		map.put("writer", dto.getId());
		String content = (String)map.get("content");
		
		System.out.println(content);
		
		content = content.replace("<p>", "");
		
		content = content.replace("</p>", "");
		
		System.out.println(content);
		
		map.put("content",content);
		
		try {
			pws.postWrite(map);
			System.out.println("등록 성공");
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("등록 실패");
		}
		
		// 게시글 최신화
		
		System.out.println(dto.getDong_num());
		
		Long dong_num = (Long)dto.getDong_num();
		
		
		try {
			
			ArrayList<PostDTO> post_list = ps.postView(dong_num);
			
			model.addAttribute("post_list",post_list);
			
			model.addAttribute("dong_num",dong_num);
			
			
		} catch (Exception e) {
			System.out.println("오류");
		}
		
		return "post";
	}

}
