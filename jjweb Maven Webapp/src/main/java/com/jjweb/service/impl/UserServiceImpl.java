package com.jjweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jjweb.model.User;
import com.jjweb.model.UserDAO;
import com.jjweb.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDAO userDAO;
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	@Override
	public User merge(User user) {
		// TODO Auto-generated method stub
		return userDAO.merge(user);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDAO.save(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDAO.delete(user);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}


	@Override
	public List<User> findByContent(Object content) {
		// TODO Auto-generated method stub
		return userDAO.findByContent(content);
	}

	@Override
	public List<User> findByNamePassword(String name, String password) {
		// TODO Auto-generated method stub
		return userDAO.findByNamePassword(name, password);
	}

}
