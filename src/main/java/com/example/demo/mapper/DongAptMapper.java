package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DongAptDTO;
import com.example.demo.model.UserDTO;

@Mapper
@Repository
public interface DongAptMapper {
	
	public DongAptDTO dongApt(UserDTO dto);

}
