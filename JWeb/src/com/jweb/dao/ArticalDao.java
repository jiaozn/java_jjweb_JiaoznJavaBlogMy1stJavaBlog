package com.jweb.dao;

import com.jweb.model.Artical;

public interface ArticalDao{

	public Artical getById(int id);
	public void updateArticalDao(Artical artical);
	public void addArtical(Artical artical);
}
