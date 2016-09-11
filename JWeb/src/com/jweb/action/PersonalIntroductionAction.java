package com.jweb.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jweb.model.PersonalIntroduction;
import com.jweb.service.PersonalIntroductionService;
import com.opensymphony.xwork2.ActionSupport;


//@Component
//@Scope(value="prototype")
public class PersonalIntroductionAction extends ActionSupport{
	
	private PersonalIntroductionService personalIntroductionService;
	private PersonalIntroduction personalIntroduction;
	@Override
	public String execute() throws Exception {
		PersonalIntroduction personalIntroduction=personalIntroductionService.getPersonalIntroductionById(1);
		
		return "show_personalIntroduction";
	}
	public String edit(){
		return "personalIntroduction_edit";
		}
	public String update(){
		return "show_personalIntroduction";
	}
	
	
	
	public PersonalIntroductionService getPersonalIntroductionService() {
		return personalIntroductionService;
	}
	
	@Resource
	public void setPersonalIntroductionService(
			PersonalIntroductionService personalIntroductionService) {
		this.personalIntroductionService = personalIntroductionService;
	}
	public PersonalIntroduction getPersonalIntroduction() {
		return personalIntroduction;
	}
	public void setPersonalIntroduction(PersonalIntroduction personalIntroduction) {
		this.personalIntroduction = personalIntroduction;
	}
	
}
