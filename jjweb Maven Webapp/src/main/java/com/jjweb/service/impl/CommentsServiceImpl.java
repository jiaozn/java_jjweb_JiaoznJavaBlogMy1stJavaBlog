package com.jjweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jjweb.model.Comments;
import com.jjweb.model.CommentsDAO;
import com.jjweb.service.CommentsService;
@Service
public class CommentsServiceImpl implements CommentsService{
	@Resource
	private CommentsDAO commentsDAO;
	
	
	@Override
	public void save(Comments comments) {
		// TODO Auto-generated method stub
		commentsDAO.save(comments);
	}

	@Override
	public void delete(Comments comments) {
		// TODO Auto-generated method stub
		commentsDAO.delete(comments);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return commentsDAO.findAll();
	}

	@Override
	public Comments merge(Comments comments) {
		// TODO Auto-generated method stub
		return commentsDAO.merge(comments);
	}

	@Override
	public Comments findById(Integer id) {
		// TODO Auto-generated method stub
		return commentsDAO.findById(id);
	}

	@Override
	public List findByArticalId(int id) {
		// TODO Auto-generated method stub
		return commentsDAO.findByArticalId(id);
	}

}
