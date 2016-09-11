package com.jweb.action;

import com.opensymphony.xwork2.ActionSupport;


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
