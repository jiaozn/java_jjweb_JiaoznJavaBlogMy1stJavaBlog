package com.jjweb.service;

import java.util.List;

import com.jjweb.model.Comments;

public interface CommentsService {
	public void save(Comments comments);
	public void delete(Comments comments);
	public List findAll();
	public Comments merge(Comments comments);
	public Comments findById(java.lang.Integer id);
	public List findByArticalId(int id);
}
