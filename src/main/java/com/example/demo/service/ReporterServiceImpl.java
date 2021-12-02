package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ReporterMapper;

@Service
public class ReporterServiceImpl implements ReporterService {

	@Autowired
	private ReporterMapper reporterMapper;

	public ArrayList<String> reporter(int no) throws Exception {

		return reporterMapper.reporter(no);
	}

}
