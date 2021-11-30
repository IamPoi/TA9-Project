package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserLocationMapper;
import com.example.demo.model.LocationDTO;

@Service
public class UserLocationServiceImpl  implements UserLocationService{
	
	@Autowired
	private UserLocationMapper userLocationMapper;

	@Override
	public LocationDTO userLocation(Long dong_num) throws Exception {
		return userLocationMapper.userLocation(dong_num);
	}

}
