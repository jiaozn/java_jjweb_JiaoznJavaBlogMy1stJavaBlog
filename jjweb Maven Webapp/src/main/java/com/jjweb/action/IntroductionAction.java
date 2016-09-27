package com.jjweb.action;



import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jjweb.model.CounterSessionDAO;
import com.jjweb.model.Introduction;
import com.jjweb.service.IntroductionService;
import com.opensymphony.xwork2.ActionSupport;

public class IntroductionAction extends ActionSupport{
	private Introduction introduction;
	
	
	@Resource
	private IntroductionService introductionService;
	@Resource
	private CounterSessionDAO counterSessionDAO;
	private int sessionRecord;
	
	@Action(value="introduction_show",results={
			@Result(name="success",location = "/WEB-INF/content/service_introduction_show.jsp")})
	public String execute(){
		introduction=introductionService.findById(1);
		int access=Integer.parseInt(introduction.getAccess()==null?"0":introduction.getAccess());
		introduction.setAccess(String.valueOf(++access));
		introductionService.merge(introduction);
		
		sessionRecord=counterSessionDAO.findAll().size()==0?1:counterSessionDAO.findAll().size();
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
	public CounterSessionDAO getCounterSessionDAO() {
		return counterSessionDAO;
	}
	public void setCounterSessionDAO(CounterSessionDAO counterSessionDAO) {
		this.counterSessionDAO = counterSessionDAO;
	}
	public int getSessionRecord() {
		return sessionRecord;
	}
	public void setSessionRecord(int sessionRecord) {
		this.sessionRecord = sessionRecord;
	}
}
