package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PostMapper;
import com.example.demo.model.PostDTO;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostMapper postmapper;

	@Override
	public ArrayList<PostDTO> postView(int dong_num) throws Exception {
		
		System.out.println(postmapper.postView(dong_num));
		
		return postmapper.postView(dong_num);
	}
}
