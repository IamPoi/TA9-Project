package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import com.example.demo.model.CommentDTO;

@Mapper
@Repository
public interface MyCommentMapper {
	
	public ArrayList<CommentDTO> myCommentView(Map<String, Object> map);

}
