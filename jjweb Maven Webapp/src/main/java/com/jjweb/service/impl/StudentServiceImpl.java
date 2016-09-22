package com.jjweb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jjweb.model.Student;
import com.jjweb.model.StudentDAO;
import com.jjweb.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Resource
	private StudentDAO studentDAO;
	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return studentDAO.findById(id);
	}

}
