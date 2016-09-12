package com.jweb.service;

import com.jweb.model.Artical;


public interface ArticalService {
	public Artical getArticalById(int id);
	public void updateArtical(Artical artical);
	public void addArtical(Artical artical);
}
