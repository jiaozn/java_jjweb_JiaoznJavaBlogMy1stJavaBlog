package com.jjweb.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jjweb.model.AccessRecordDAO;
import com.jjweb.model.AccessRecord;
import com.opensymphony.xwork2.ActionSupport;

public class AccessRecordAction extends ActionSupport{
	@Resource
	private AccessRecordDAO accessRecordDAO;
	
	private List<AccessRecord> listAccessRecord;
	
	@Action(value="accessRecord_showAll",results={
			@Result(name="success",location = "/WEB-INF/content/service_accessRecord_showAll.jsp")})
	public String execute(){                                  //service_accessRecord_showAll.jsp
		listAccessRecord=new ArrayList<AccessRecord>();
		listAccessRecord=accessRecordDAO.findAll();
		return SUCCESS;
	}

	public AccessRecordDAO getAccessRecordDAO() {
		return accessRecordDAO;
	}

	public void setAccessRecordDAO(AccessRecordDAO accessRecordDAO) {
		this.accessRecordDAO = accessRecordDAO;
	}

	public List<AccessRecord> getListAccessRecord() {
		return listAccessRecord;
	}

	public void setListAccessRecord(List<AccessRecord> listAccessRecord) {
		this.listAccessRecord = listAccessRecord;
	}
}
