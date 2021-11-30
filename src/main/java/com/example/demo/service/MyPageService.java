package com.example.demo.service;

import java.util.ArrayList;
import java.util.Map;

import com.example.demo.model.AptInfoDTO;

public interface MyPageService {

	public ArrayList<AptInfoDTO> aptInfo(Map<String, Object> map) throws Exception;

}
