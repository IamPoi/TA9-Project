package com.example.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.AptInfoDTO;
import com.example.demo.model.LocationDTO;
import com.example.demo.model.UserDTO;
import com.example.demo.service.RankService;
import com.example.demo.service.UserLocationService;

@Controller
@RequestMapping("/")
public class RankController {
	
	@Autowired
	private RankService rs;
	
	@Autowired
	private UserLocationService uls;
	
	
	@GetMapping("/rankView")
	public String rank(Model model,HttpSession session) {
		
		
		UserDTO dto = (UserDTO)session.getAttribute("user");
		
		Long dong_num = dto.getDong_num();
		
		try {
			ArrayList<AptInfoDTO> rank_list = rs.rankView(dong_num);
			
			model.addAttribute("rank_list",rank_list);
			
			LocationDTO location =  uls.userLocation(dong_num);
			
			model.addAttribute("location",location);
			
			System.out.println(rank_list.get(0).toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "rank";
	}

}
