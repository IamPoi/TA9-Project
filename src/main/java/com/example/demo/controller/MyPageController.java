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

import com.example.demo.model.AptInfoDTO;
import com.example.demo.model.CommentDTO;
import com.example.demo.model.DongAptDTO;
import com.example.demo.model.PostDTO;
import com.example.demo.model.UserDTO;
import com.example.demo.service.DongAptService;
import com.example.demo.service.MyCommentService;
import com.example.demo.service.MyPageService;
import com.example.demo.service.MyPostService;

@Controller
@RequestMapping("/")
public class MyPageController {
	
	@Autowired
	private DongAptService das;
	
	@Autowired
	private MyPageService mps;
	
	@Autowired
	private MyPostService mpos;
	
	@Autowired
	private MyCommentService mcs;
	
	@GetMapping("mypage")
	public String Mypage(HttpSession session,Model model,@RequestParam Map<String, Object> map) {
		
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		
		System.out.println("mypage 접근");
		
		UserDTO dto = (UserDTO)session.getAttribute("user");
		
		
		map.put("userId", dto.getId());
		
		try {
			DongAptDTO dongAptDTO = das.dongApt(dto);
			
			String dong_apt = (String)dongAptDTO.getDong()+"_"+(String)dongAptDTO.getApt();
			
			AptInfoDTO aptInfo = mps.aptInfo(dong_apt);
			
			model.addAttribute("aptInfo",aptInfo);
			
			ArrayList<PostDTO> myPostList =mpos.myPostView(map);
			
			model.addAttribute("myPostList",myPostList);
			
			ArrayList<CommentDTO> myCommentList = mcs.myCommentView(map);
			
			model.addAttribute("myCommentList",myCommentList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return "mypage";
	}

}
