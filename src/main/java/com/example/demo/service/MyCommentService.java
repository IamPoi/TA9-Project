package com.example.demo.service;

import java.util.ArrayList;
import java.util.Map;

import com.example.demo.model.CommentDTO;

public interface MyCommentService {
	public ArrayList<CommentDTO> myCommentView(Map<String, Object> map) throws Exception;
}
