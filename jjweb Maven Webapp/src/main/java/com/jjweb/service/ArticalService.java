package com.jjweb.service;

import java.util.List;

import com.jjweb.model.Artical;

public interface ArticalService {
	public Artical findById(Integer id);
	public Artical merge(Artical artical);
	public void save(Artical artical);
	public List findAll();
	public void delete(Artical artical);
}
