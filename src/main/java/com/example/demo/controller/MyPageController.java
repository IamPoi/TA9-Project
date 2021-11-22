package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.AptInfoDTO;
import com.example.demo.model.DongAptDTO;
import com.example.demo.model.UserDTO;
import com.example.demo.service.DongAptService;
import com.example.demo.service.MyPageService;

@Controller
@RequestMapping("/")
public class MyPageController {
	
	@Autowired
	private DongAptService das;
	
	@Autowired
	private MyPageService mps;
	
	
	@GetMapping("mypage")
	public String Mypage(HttpSession session,Model model) {
		System.out.println("mypage 접근");
		
		UserDTO dto = (UserDTO)session.getAttribute("user");
		
		try {
			DongAptDTO dongAptDTO = das.dongApt(dto);
			System.out.println(dongAptDTO.getApt());
			System.out.println(dongAptDTO.getDong());
			
			String dong_apt = (String)dongAptDTO.getDong()+"_"+(String)dongAptDTO.getApt();
			
			AptInfoDTO aptInfo = mps.aptInfo(dong_apt);
			
			System.out.println(aptInfo.getDong_apt());
			System.out.println(aptInfo.getMax_price());
			System.out.println(aptInfo.getMin_price());
			
			model.addAttribute("aptInfo",aptInfo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return "mypage";
	}

}
