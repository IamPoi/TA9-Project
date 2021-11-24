package com.example.demo.service;

import java.util.ArrayList;
import java.util.Map;

import com.example.demo.model.PostDTO;

public interface PostSearchService {
	
	public ArrayList<PostDTO> postSearch(PostDTO dto) throws Exception;

}
