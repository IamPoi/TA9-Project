package com.example.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.CommentDTO;
import com.example.demo.model.PostDTO;
import com.example.demo.service.CommentViewService;
import com.example.demo.service.PostDetailService;
import com.example.demo.service.ReporterService;

@Controller
@RequestMapping("")
public class PostDetailController {
	
	@Autowired
	private PostDetailService pds;
	
	@Autowired
	private CommentViewService cvs;
	
	@Autowired
	private ReporterService rs;
	
	@PostMapping("post_detail")
	public void postDetailView_Post() {
		System.out.println("안녕하세요");
	}
	
	@GetMapping("post_detail")
	public String postDetailView(@RequestParam int no, Model model,HttpSession session) {
		
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		
		System.out.println("게시판 자세히 보기");
		
		try {
			
			ArrayList<String> reporter = rs.reporter(no);
			
			PostDTO dto =  pds.postDetailView(no);
			ArrayList<CommentDTO> comment_list = cvs.CommentViewService(no);
			
			model.addAttribute("post_detail",dto);
			model.addAttribute("comment_list",comment_list);
			model.addAttribute("reporter",reporter);
			
			System.out.println(reporter.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "post_detail";
	}

}
