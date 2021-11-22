package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CommentViewMapper;
import com.example.demo.model.CommentDTO;

@Service
public class CommentViewServiceImpl implements CommentViewService{
	
	@Autowired
	private CommentViewMapper commentMapper;

	@Override
	public ArrayList<CommentDTO> CommentViewService(int no) throws Exception {
	
		return commentMapper.commentView(no);
	}
	
	
	
	 
}
