package com.jjweb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jjweb.model.Introduction;
import com.jjweb.model.IntroductionDAO;
import com.jjweb.service.IntroductionService;
@Service
public class IntroductionServiceImpl implements IntroductionService{
	@Resource
	private IntroductionDAO introductionDAO;
	@Override
	public Introduction findById(Integer id) {
		// TODO Auto-generated method stub
		return introductionDAO.findById(id);
	}
	@Override
	public Introduction merge(Introduction introduction) {
		// TODO Auto-generated method stub
		return introductionDAO.merge(introduction);
	}

}
