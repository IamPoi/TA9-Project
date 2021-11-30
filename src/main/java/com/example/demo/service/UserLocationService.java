package com.example.demo.service;

import com.example.demo.model.LocationDTO;

public interface UserLocationService {
	
	public LocationDTO userLocation(Long dong_num) throws Exception;

}
