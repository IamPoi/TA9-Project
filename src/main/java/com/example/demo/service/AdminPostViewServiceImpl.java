package com.example.demo.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.AdminPostViewMapper;
import com.example.demo.model.PostDTO;

@Service
public class AdminPostViewServiceImpl implements AdminPostViewService {

	@Autowired
	private AdminPostViewMapper adminPostViewMapper;

	@Override
	public ArrayList<PostDTO> allPostView(Map<String, Object> map) throws Exception {
		
		System.out.println("????????????");

		return adminPostViewMapper.allPostView(map);
	}

}
