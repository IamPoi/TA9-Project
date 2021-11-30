package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LocationDTO;

@Mapper
@Repository
public interface UserLocationMapper {
	
	public LocationDTO userLocation(Long dong_num);


}
