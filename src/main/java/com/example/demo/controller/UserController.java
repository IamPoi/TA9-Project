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

import com.example.demo.model.LocationDTO;
import com.example.demo.model.UserDTO;
import com.example.demo.service.UserLocationService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private UserLocationService uls;
	
	@GetMapping("/login_page")
	public String login() {
		System.out.println("로그인??");
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		System.out.println("로그인 시도");
		try {

			SHA256 sha256 = new SHA256();

			String pw = (String) map.get("userpw");

			System.out.println(pw);

			String encod_pw = sha256.encrypt(pw);

			System.out.println("ENCOD : " + encod_pw);

			map.put("userpw", encod_pw);

			UserDTO user = us.login(map);

			if (user.getActivation() == 0) {
				model.addAttribute("msg", "아이디가 비활성화 상태입니다. 관리자에게 문의해주세요");
				return "error";
			}

			if (user != null) {
				session.setAttribute("user", user);
			}
			
			Long dong_num = user.getDong_num();

			LocationDTO locationDTO = uls.userLocation(dong_num);

			session.setAttribute("user_location", locationDTO);

			return "redirect:/";

		} catch (Exception e) {
			e.printStackTrace();

			model.addAttribute("msg", "아이디 또는 비밀번호를 확인하고 다시 로그인 해주세요.");

			return "error";
		}

	}
	
}
