package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AptInfoDTO;

@Mapper
@Repository
public interface AptDetailMapper {
	
	public AptInfoDTO aptDetailView(Map<String, Object> map);

}
