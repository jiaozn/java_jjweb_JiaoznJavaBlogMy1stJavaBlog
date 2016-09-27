package com.jjweb.service;

import com.jjweb.model.Introduction;

public interface IntroductionService {
	public Introduction findById(Integer id);
	public Introduction merge(Introduction introduction);
	public void save(Introduction introduction);
}
