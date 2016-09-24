package com.jjweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jjweb.model.Category;
import com.jjweb.model.CategoryDAO;
import com.jjweb.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Resource
	CategoryDAO categoryDAO;
	@Override
	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		return categoryDAO.findById(id);
	}

	@Override
	public Category merge(Category category) {
		// TODO Auto-generated method stub
		return categoryDAO.merge(category);
	}

	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.save(category);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}

	@Override
	public void delete(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.delete(category);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.update(category);
	}
	
}
