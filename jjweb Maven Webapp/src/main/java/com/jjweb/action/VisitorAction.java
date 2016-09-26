package com.jjweb.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jjweb.model.Artical;
import com.jjweb.model.CounterSession;
import com.jjweb.model.CounterSessionDAO;
import com.opensymphony.xwork2.ActionSupport;

public class VisitorAction extends ActionSupport{
	@Resource
	private CounterSessionDAO counterSessionDAO;//=new CounterSessionDAO();
	private List<CounterSession> listCounterSession;
	@Action(value="counterSession_showAll",results={
			@Result(name="success",location = "/WEB-INF/content/service_counterSession_showAll.jsp")})
	public String execute(){
		listCounterSession=new ArrayList<CounterSession>();
		listCounterSession=counterSessionDAO.findAll();
		
		System.out.println("6666------"+listCounterSession.toString());
		return SUCCESS;
	}
	public CounterSessionDAO getCounterSessionDAO() {
		return counterSessionDAO;
	}
	public void setCounterSessionDAO(CounterSessionDAO counterSessionDAO) {
		this.counterSessionDAO = counterSessionDAO;
	}
	public List<CounterSession> getListCounterSession() {
		return listCounterSession;
	}
	public void setListCounterSession(List<CounterSession> listCounterSession) {
		this.listCounterSession = listCounterSession;
	}
}
