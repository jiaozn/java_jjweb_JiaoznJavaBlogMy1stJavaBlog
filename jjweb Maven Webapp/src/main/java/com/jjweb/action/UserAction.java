package com.jjweb.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jjweb.model.Artical;
import com.jjweb.model.User;
import com.jjweb.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private User user;
	@Resource
	private UserService userService;
	private List<User> listUser;
	@Action(value="user_showAll",results={
			@Result(name="success",location = "/WEB-INF/content/service_user_showAll.jsp")})
	public String execute(){
		listUser=new ArrayList<User>();
		listUser=userService.findAll();
		return SUCCESS;
	}
	@Action(value="user_show",results={
			@Result(name="success",location = "/WEB-INF/content/service_user_show.jsp")})
	public String user_show(){
		user=userService.findById(user.getId());
		return SUCCESS;
	}
	
	@Action(value="user_add",results={
			@Result(name="input",location = "/WEB-INF/content/service_user_add.jsp")})
	public String user_add(){
		return INPUT;
	}
	@Action(value="user_addCommit",results={
			@Result(name="input",location = "/WEB-INF/content/service_user_addCommit.jsp")})
	public String user_addCommit(){
		user.setTime(new Timestamp(new Date().getTime()));
		userService.save(user);
		return INPUT;
	}	
	
	@Action(value="user_delete",results={
			@Result(name="success",location = "/WEB-INF/content/service_user_deleteCommit.jsp")})
	public String user_delete(){
		user=userService.findById(user.getId());
		userService.delete(user);
		return SUCCESS;
	}
	@Action(value="user_edit",results={
			@Result(name="success",location = "/WEB-INF/content/service_user_edit.jsp")})
	public String user_edit(){
	//	System.out.println("1---------"+user.getId());
		user=userService.findById(user.getId());
		//System.out.println("3---------"+user.getName());
		return SUCCESS;
	}
	@Action(value="user_editCommit",results={
			@Result(name="success",location = "/WEB-INF/content/service_user_editCommit.jsp")})
	public String user_editCommit(){
		
		//User usertemp=userService.findById(user.getId());
		//System.out.println(user.getId());
		user.setTime(new Timestamp(new Date().getTime()));
		//System.out.println(user.getId()+"---"+user.getName()+user.getAddress()+user.getEmail()+user.toString());
		
		userService.merge(user);
		//System.out.println("finish");
		//ActionContext.getContext().getSession().clear();
		ActionContext.getContext().getSession().put("userx", user);
		return SUCCESS;
	}
	
	
	@Action(value="user_adminEdit",results={
			@Result(name="success",location = "/WEB-INF/content/service_user_edit.jsp")})
	public String user_adminEdit(){
	//	System.out.println("1---------"+user.getId());
		user=userService.findById(user.getId());
		//System.out.println("3---------"+user.getName());
		return SUCCESS;
	}
	@Action(value="user_adminEditCommit",results={
			@Result(name="success",location = "/WEB-INF/content/service_user_editCommit.jsp")})
	public String user_adminEditCommit(){
		
		//User usertemp=userService.findById(user.getId());
		//System.out.println(user.getId());
		user.setTime(new Timestamp(new Date().getTime()));
		//System.out.println(user.getId()+"---"+user.getName()+user.getAddress()+user.getEmail()+user.toString());
		
		userService.merge(user);
		//System.out.println("finish");
		//ActionContext.getContext().getSession().clear();
		//ActionContext.getContext().getSession().put("userx", user);
		return SUCCESS;
	}
	
	
	@Action(value="user_login",results={
			@Result(name="input",location = "/WEB-INF/content/service_user_login.jsp")})
	public String user_login(){
		return INPUT;
	}
	@Action(value="user_loginCommit",results={
			@Result(name="success",location = "/WEB-INF/content/service_user_loginCommit.jsp"),
			@Result(name="input",location = "/WEB-INF/content/service_user_login.jsp")})
	public String user_loginCommit(){
		String input_password=user.getPassword();
		//System.out.println("1password---------"+input_password);
		listUser=userService.findByNamePassword(user.getName(), user.getPassword());
		//System.out.println("2listUser--------------"+listUser);
		if(listUser.size()!=0&&listUser!=null) {
			User userx=listUser.get(0);
			//System.out.println("3userx get--------------"+userx);
			//if(userx.getPassword().equals(input_password))
				//System.out.println("4相等通過--------------");
				ActionContext.getContext().getSession().put("userx", userx);
				//System.out.println("5放入session成功--------------");
				return SUCCESS;
		}
		return INPUT;
	}
	@Action(value="user_logout",results={
			@Result(name="input",location = "/WEB-INF/content/service_user_login.jsp")})
	public String user_logout(){
		ActionContext.getContext().getSession().clear();
		return INPUT;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public List<User> getListUser() {
		return listUser;
	}
	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
	
}
