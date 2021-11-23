package com.example.demo.service;

import java.util.ArrayList;
import java.util.Map;

import com.example.demo.model.PostDTO;

public interface MyPostService {
	public ArrayList<PostDTO> myPostView(Map<String, Object> map) throws Exception; 
}
