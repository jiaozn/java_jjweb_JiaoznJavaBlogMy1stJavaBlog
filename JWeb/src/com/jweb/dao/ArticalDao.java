package com.jweb.dao;

import java.util.List;

import com.jweb.model.Artical;

public interface ArticalDao{

	public Artical getById(int id);
	public void updateArticalDao(Artical artical);
	public void addArtical(Artical artical);
	public List<Artical> listAll();
	public void deleteById(Artical artical);
}
