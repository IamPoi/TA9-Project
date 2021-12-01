package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.PostDTO;
import com.example.demo.model.UserDTO;
import com.example.demo.service.PostNoService;
import com.example.demo.service.PostService;
import com.example.demo.service.PostWriteService;

@Controller
@RequestMapping("/")
public class PostWriteController {
	
	@Autowired
	private PostService ps;
	
	@Autowired
	private PostWriteService pws;
	
	@Autowired
	private PostNoService pns;

	@GetMapping("post_write")
	public String post_write() {
		return "post_write";
	}
	
	@PostMapping("post_enrollment")
	public String post_enrollement(@RequestParam Map<String,Object> map,@RequestParam("img_name") MultipartFile file, Model model,HttpSession session) {
		int no = 0;
		try {
			no = pns.postNo();
		} catch (Exception e) {

		}
		
		//no는 가장 마지막 글 번호
		no = no + 1;
		
		System.out.println("hihi");

		StringBuilder sb = new StringBuilder();

		// file image 가 없을 경우
		if (file.isEmpty()) {
			sb.append("none");
		} else {
			sb.append(file.getOriginalFilename());
		}

		if (!file.isEmpty()) {
			File dest = new File("C:\\Users\\ta9\\Desktop\\STS_Prac\\Spring_Prac\\src\\main\\webapp\\img/" +no+"-"+sb.toString());
			try {
				file.transferTo(dest);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// db에 파일 위치랑 번호 등록
		}
		
		UserDTO dto =  (UserDTO)session.getAttribute("user");
		System.out.println("게시글 등록 시도");
		map.put("dong_num", dto.getDong_num());
		map.put("writer", dto.getId());
		map.put("no", no);
		
		System.out.println("-------------------------------------------");
		System.out.println(sb.toString());
		map.put("img_name", no+"-"+sb.toString());
		
		try {
			pws.postWrite(map);
			System.out.println("등록 성공");
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("등록 실패");
		}
		
		
		System.out.println(dto.getDong_num());
		
		Long dong_num = (Long)dto.getDong_num();
		
		
		try {
			// 게시글 최신화
			
			ArrayList<PostDTO> post_list = ps.postView(dong_num);
			
			model.addAttribute("post_list",post_list);
			
			model.addAttribute("dong_num",dong_num);
			
			
		} catch (Exception e) {
			System.out.println("오류");
		}
		
		
		
		return "redirect:/post";
	}

}
