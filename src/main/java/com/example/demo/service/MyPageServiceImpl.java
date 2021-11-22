package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MyPageMapper;
import com.example.demo.model.AptInfoDTO;

@Service	
public class MyPageServiceImpl implements MyPageService{
	
	@Autowired
	private MyPageMapper mpm;

	@Override
	public AptInfoDTO aptInfo(String dong_apt) throws Exception {
		System.out.println("MyPage 아파트 정보 가져오기");
		return mpm.aptInfo(dong_apt);
	}


}
