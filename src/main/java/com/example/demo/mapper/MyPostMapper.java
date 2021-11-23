package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PostDTO;

@Mapper
@Repository
public interface MyPostMapper {
	
	public ArrayList<PostDTO> myPostView(Map<String, Object> map);
	
}
