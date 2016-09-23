package com.jjweb.action;



import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jjweb.model.Introduction;
import com.jjweb.service.IntroductionService;
import com.opensymphony.xwork2.ActionSupport;

public class IntroductionAction extends ActionSupport{
	private Introduction introduction;
	
	
	@Resource
	private IntroductionService introductionService;
	@Action(value="introduction_show",results={
			@Result(name="success",location = "/WEB-INF/content/service_introduction_show.jsp")})
	public String execute(){
		introduction=introductionService.findById(1);
		return SUCCESS;
	}
	@Action(value="introduction_edit",results={
			@Result(name="input",location="/WEB-INF/content/service_introduction_edit.jsp")
	})
	public String edit(){
		introduction=introductionService.findById(1);
		return INPUT;
	}
	@Action(value="introduction_editCommit",results={
			@Result(name="success",location="/WEB-INF/content/service_introduction_editCommit.jsp")
	})
	public String editCommit(){
		introduction.setId(1);
		introduction.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		introduction=introductionService.merge(introduction);
		return SUCCESS;
	}
	
	public Introduction getIntroduction() {
		return introduction;
	}
	public void setIntroduction(Introduction introduction) {
		this.introduction = introduction;
	}
	public IntroductionService getIntroductionService() {
		return introductionService;
	}
	public void setIntroductionService(IntroductionService introductionService) {
		this.introductionService = introductionService;
	}
}
