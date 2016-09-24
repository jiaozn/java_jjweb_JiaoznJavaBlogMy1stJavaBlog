package com.jjweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jjweb.model.Artical;
import com.jjweb.model.ArticalDAO;
import com.jjweb.service.ArticalService;
@Service
public class ArticalServiceImpl implements ArticalService{
	@Resource
	private ArticalDAO articalDAO;
	@Override
	public Artical findById(Integer id) {
		// TODO Auto-generated method stub
		return articalDAO.findById(id);
	}

	@Override
	public Artical merge(Artical artical) {
		// TODO Auto-generated method stub
		return articalDAO.merge(artical);
	}

	@Override
	public void save(Artical artical) {
		// TODO Auto-generated method stub
		articalDAO.save(artical);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return articalDAO.findAll();
	}

	@Override
	public void delete(Artical artical) {
		// TODO Auto-generated method stub
		articalDAO.delete(artical);
	}
	
	
}
