package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserDTO;
import com.example.demo.service.CommentViewService;
import com.example.demo.service.CommentWriteService;
import com.example.demo.service.PostDetailService;

@Controller
@RequestMapping("/")
public class CommentController {
	
	@Autowired
	private PostDetailService pds;

	@Autowired
	private CommentViewService cvs;
	
	@Autowired
	private CommentWriteService cws;
	
	@PostMapping("/comment_write")
	public String commentView(@RequestParam Map<String, Object> map,Model model,HttpSession session) {
		
		System.out.println("댓글 등록 시도");
		
		
		UserDTO dto = (UserDTO)session.getAttribute("user");
		String comment_writer = dto.getId();
		
		map.put("comment_writer", comment_writer);
		
		System.out.println(map.toString());
		
		String no = (String)map.get("no");
		
		System.out.println(no);
		
		try {
			cws.commentWrite(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/post_detail?no="+no;
		
	}
	
}
