package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository	
public interface CommentWriteMapper {
	public void commentWrite(Map<String, Object> map);

}
