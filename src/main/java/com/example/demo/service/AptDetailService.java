package com.example.demo.service;

import java.util.Map;

import com.example.demo.model.AptInfoDTO;

public interface AptDetailService {
	
	public AptInfoDTO aptDetailView(Map<String, Object> map) throws Exception;

}
