package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AptInfoDTO;
import com.example.demo.model.DongAptDTO;

@Mapper
@Repository
public interface MyPageMapper {
	
	public AptInfoDTO aptInfo(String dong_apt);
}
