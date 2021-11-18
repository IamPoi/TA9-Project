package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDTO;

@Mapper
@Repository
public interface JoinMapper {
	
	public void join(Map<String, Object> map);
	
}
