package com.jweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jweb.dao.ArticalDao;
import com.jweb.model.Artical;

@Component
public class ArticalServiceImpl implements ArticalService {

	private ArticalDao articalDao;

	public Artical getArticalById(int id) {
		Artical artical = articalDao.getById(id);
		return artical;
	}

	public ArticalDao getArticalDao() {
		return articalDao;
	}

	@Resource
	public void setArticalDao(ArticalDao articalDao) {
		this.articalDao = articalDao;
	}

	public void updateArtical(Artical artical) {
		articalDao.updateArticalDao(artical);
	}

	public void addArtical(Artical artical) {
		articalDao.addArtical(artical);
	}

}
