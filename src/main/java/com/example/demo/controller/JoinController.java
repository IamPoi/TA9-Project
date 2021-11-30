package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.IdCheckService;
import com.example.demo.service.JoinService;

@Controller
@RequestMapping("/")
public class JoinController {
	
	@Autowired
	private JoinService js;
	
	@GetMapping("/join_page")
	public String joinPage() {
		System.out.println("회원가입 페이지 이동");
		return "join";
	}
	
	@Autowired
	private IdCheckService ics;
	
	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value="/idCheck", method = RequestMethod.POST)
	public int idChk(String id) throws Exception {
		System.out.println("아이디 중복확인");
		
		int result = ics.idCheck(id);
		
		return result;
	}
	
	
	@PostMapping("/join")
	public String join(@RequestParam Map<String, Object> map, Model model) {
		
		System.out.println("회원가입 시도");
		
		System.out.println(map.toString());
		
		String dong_apt = (String)map.get("dong_apt");
		
		dong_apt = dong_apt.replace("(", "");
		dong_apt = dong_apt.replace(")", "");
		dong_apt = dong_apt.replace(" ", "");
		
		String road = (String)map.get("road");
		
		String list [] = road.split(" ");
		
		String doName = list[0];
		String gooName = list[1]; 
		
		String want_list [] = dong_apt.split(",");
		
		System.out.println(want_list);
		
		String dong = want_list[0];
		String apt = want_list[1];
		
		map.put("dong", dong);
		map.put("apt", apt);
		map.put("doName",doName);
		map.put("gooName", gooName);
		
		System.out.println(map.toString());

		try {
			js.join(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
		
	}
	
}
