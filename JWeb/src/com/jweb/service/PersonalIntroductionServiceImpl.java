package com.jweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jweb.dao.PersonalIntroductionDao;
import com.jweb.model.PersonalIntroduction;

@Component
public class PersonalIntroductionServiceImpl implements PersonalIntroductionService{

	private PersonalIntroductionDao personalIntroductionDao;
	public PersonalIntroduction getPersonalIntroductionById(int id) {
		PersonalIntroduction personalIntroduction=personalIntroductionDao.getById(id);
		return personalIntroduction;
	}
	
	
	
	public PersonalIntroductionDao getPersonalIntroductionDao() {
		return personalIntroductionDao;
	}
	@Resource
	public void setPersonalIntroductionDao(
			PersonalIntroductionDao personalIntroductionDao) {
		this.personalIntroductionDao = personalIntroductionDao;
	}



	public void updatePersonalIntroduction(
			PersonalIntroduction personalIntroduction) {
		personalIntroductionDao.updatePersonalIntroductionDao(personalIntroduction);
	}

}
