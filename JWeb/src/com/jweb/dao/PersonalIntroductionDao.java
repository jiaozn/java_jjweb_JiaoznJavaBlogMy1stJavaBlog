package com.jweb.dao;

import com.jweb.model.PersonalIntroduction;

public interface PersonalIntroductionDao{

	public PersonalIntroduction getById(int id);
	public void updatePersonalIntroductionDao(PersonalIntroduction personalIntroduction);
}
