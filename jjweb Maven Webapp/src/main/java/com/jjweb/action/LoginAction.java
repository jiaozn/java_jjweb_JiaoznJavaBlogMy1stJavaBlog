package com.jjweb.action;

import javax.annotation.Resource;
import javax.xml.ws.Action;

import com.jjweb.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	private String name;
	private String password;
	@Resource
	private StudentService studentService;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute(){
		if(name.equals("steve")&&password.equals("123"))
			return SUCCESS;
		else
			return INPUT;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}
