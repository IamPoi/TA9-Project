package com.example.demo.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MyPageMapper;
import com.example.demo.model.AptInfoDTO;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageMapper mpm;

	@Override
	public ArrayList<AptInfoDTO> aptInfo(Map<String, Object> map) throws Exception {
		System.out.println("MyPage 아파트 정보 가져오기");
		return mpm.aptInfo(map);
	}

}
