package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.PostDTO;

public interface PostService {
	
	public ArrayList<PostDTO> postView(Long dong_num) throws Exception;

}
