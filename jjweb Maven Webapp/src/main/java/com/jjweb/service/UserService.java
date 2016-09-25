package com.jjweb.service;

import java.util.List;

import com.jjweb.model.User;

public interface UserService {
	public User findById(Integer id);
	public User merge(User user);
	public void save(User user);
	public void delete(User user);
	public List findAll();
	public List<User> findByContent(Object content) ;
	public List<User> findByNamePassword(String name,String password);
}
