package com.jweb.service;

import java.util.List;

import com.jweb.model.Artical;


public interface ArticalService {
	public Artical getArticalById(int id);
	public void updateArtical(Artical artical);
	public void addArtical(Artical artical);
	public List<Artical> listAll();
	public void delete(Artical artical);
}
