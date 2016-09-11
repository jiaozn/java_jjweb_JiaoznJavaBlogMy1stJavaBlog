package com.jweb.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;


//@Component
//@Scope(value="prototype")
public class PersonalIntroductionAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		
		return "show_personalIntroduction";
	}
	public String edit(){
		return "personalIntroduction_edit";
		}
	public String update(){
		return "show_personalIntroduction";
	}
	
}
