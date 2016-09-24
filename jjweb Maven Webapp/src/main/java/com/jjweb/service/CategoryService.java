package com.jjweb.service;

import java.util.List;

import com.jjweb.model.Category;

public interface CategoryService {
	public Category findById(Integer id);
	public Category merge(Category category);
	public void save(Category category);
	public List findAll();
	public void delete(Category category);
	public void update(Category category);
}
