package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.AptInfoDTO;
import com.example.demo.service.AptDetailService;
import com.example.demo.service.UserLocationService;

@Controller
public class AptSearchController {
	
	@Autowired
	private AptDetailService ads;
	
	@Autowired
	private UserLocationService uls;
	
	@GetMapping("/apt_search_page")
	public String apt_search_page() {
		
		
		
		return "apt_search";
	}
	
	@GetMapping("/apt_search")
	public String apt_search(@RequestParam Map<String, Object> map,Model model) {
		
		System.out.println(map.toString());
		
		String road = (String)map.get("road");
		
		String [] road_list  = road.split(" ");
		
		
		
		String road_num = road_list[road_list.length-1];
		String road_name = road_list[road_list.length-2];
		
		map.put("road_name",road_name);
		map.put("road_num",road_num);
		
		String dong_apt = (String)map.get("dong_apt");
		dong_apt = dong_apt.replace(")", "");
		
		String [] dong_apt_list = dong_apt.split(" ");
		
		String apt = dong_apt_list[dong_apt_list.length-1];
		apt = apt.replace("아파트", "");
		
		map.put("apt",apt);
		
		System.out.println(map.toString());
		
		
		
		try {
			
			AptInfoDTO aptInfo = ads.aptDetailView(map);
			
			model.addAttribute("apt_detail",aptInfo);
			
			model.addAttribute("dong",uls.userLocation(aptInfo.getDong_num()));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			model.addAttribute("MSG","준비중인 아파트 입니다....");
			System.out.println("아파트 검색 실패");
			
			e.printStackTrace();
		}
		
		
		return "apt_search_detail";
	}

}
