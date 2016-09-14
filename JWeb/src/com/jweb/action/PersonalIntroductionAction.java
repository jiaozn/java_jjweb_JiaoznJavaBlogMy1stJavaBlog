package com.jweb.action;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jweb.model.PersonalIntroduction;
import com.jweb.service.PersonalIntroductionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


//@Component
//@Scope(value="prototype")
public class PersonalIntroductionAction extends ActionSupport{
	
	private PersonalIntroductionService personalIntroductionService;
	private PersonalIntroduction personalIntroduction;
	private String newPersonalIntroduction;
	@Override
	public String execute() throws Exception {
		//System.out.println(personalIntroductionService);
		PersonalIntroduction personalIntroduction=personalIntroductionService.getPersonalIntroductionById(1);
		//System.out.println(personalIntroduction.getContent());
		Map request =(Map)ActionContext.getContext().get("request");
		request.put("personalIntroductionContent", personalIntroduction);
		return "show_personalIntroduction";
	}
	public String edit(){
		PersonalIntroduction personalIntroduction=personalIntroductionService.getPersonalIntroductionById(1);
		//System.out.println(personalIntroduction.getContent());
		Map request =(Map)ActionContext.getContext().get("request");
		request.put("personalIntroductionContent", personalIntroduction);
		return "personalIntroduction_edit";
		}
	public String updateIntroduction(){
		personalIntroduction.setId(1);
		personalIntroduction.setContent(newPersonalIntroduction);
		personalIntroduction.setDate(new Date());
		personalIntroductionService.updatePersonalIntroduction(personalIntroduction);
		
		PersonalIntroduction personalIntroduction=personalIntroductionService.getPersonalIntroductionById(1);
		Map request =(Map)ActionContext.getContext().get("request");
		request.put("personalIntroductionContent", personalIntroduction);
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
	public String getNewPersonalIntroduction() {
		return newPersonalIntroduction;
	}
	public void setNewPersonalIntroduction(String newPersonalIntroduction) {
		this.newPersonalIntroduction = newPersonalIntroduction;
	}
		
}
