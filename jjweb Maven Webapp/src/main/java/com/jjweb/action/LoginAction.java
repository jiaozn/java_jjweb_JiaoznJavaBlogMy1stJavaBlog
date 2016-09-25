package com.jjweb.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

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
	@Action(value = "login2", results = {
			@Result(name = INPUT, location = "/WEB-INF/content/fail.jsp"),
			@Result(name = SUCCESS, location = "/WEB-INF/content/success.jsp") }) 
	public String execute(){
		if(name.equals("jiaozn")&&password.equals("aghuizhang"))
			
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
