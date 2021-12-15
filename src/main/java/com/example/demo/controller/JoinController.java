package com.example.demo.controller;

import java.util.Map;

import java.security.MessageDigest;
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
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int idChk(String id) throws Exception {
		System.out.println("아이디 중복확인");

		int result = ics.idCheck(id);

		return result;
	}

	@PostMapping("/join")
	public String join(@RequestParam Map<String, Object> map, Model model) {

		try {

			System.out.println("회원가입 시도");

			System.out.println(map.toString());

			String dong_apt = (String) map.get("dong_apt");

			dong_apt = dong_apt.replace("(", "");
			dong_apt = dong_apt.replace(")", "");
			dong_apt = dong_apt.replace(" ", "");

			String road = (String) map.get("road");

			String list[] = road.split(" ");

			String doName = list[0];
			String gooName = list[1];

			if (doName.equals("전남")) {
				doName = "전라남도";
			} else if (doName.equals("경남")) {
				doName = "경상남도";
			} else if (doName.equals("전북")) {
				doName = "전라북도";
			} else if (doName.equals("경북")) {
				doName = "경상북도";
			} else if (doName.equals("충북")) {
				doName = "충청북도";
			} else if (doName.equals("충남")) {
				doName = "충청남도";
			}

			String want_list[] = dong_apt.split(",");

			System.out.println(want_list);

			String dong = want_list[0];
			String apt = want_list[1];

			map.put("dong", dong);
			map.put("apt", apt);
			map.put("doName", doName);
			map.put("gooName", gooName);

			SHA256 sha256 = new SHA256();

			String pw = (String) map.get("userpw");

			System.out.println(pw);

			String encod_pw = sha256.encrypt(pw);

			System.out.println("ENCOD : " + encod_pw);

			map.put("userpw", encod_pw);

			System.out.println(map.toString());

			js.join(map);

			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();

			model.addAttribute("msg", "회원가입을 다시 시도해주세요");
			return "error";
		}

	}

}
