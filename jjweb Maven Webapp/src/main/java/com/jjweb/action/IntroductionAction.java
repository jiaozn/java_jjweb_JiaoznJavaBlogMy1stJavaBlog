package com.jjweb.action;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jjweb.model.Artical;
import com.jjweb.model.Comments;
import com.jjweb.model.CommentsDTO;
import com.jjweb.model.CounterSessionDAO;
import com.jjweb.model.Introduction;
import com.jjweb.model.User;
import com.jjweb.service.ArticalService;
import com.jjweb.service.CommentsService;
import com.jjweb.service.IntroductionService;
import com.jjweb.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class IntroductionAction extends ActionSupport{
	private Introduction introduction;
	
	
	@Resource
	private IntroductionService introductionService;
	@Resource
	private CounterSessionDAO counterSessionDAO;
	private int sessionRecord;
	
	@Resource
	private CommentsService commentsService;
	private List<Comments> listComments;
	private List<CommentsDTO> listCommentsDTO;
	@Resource
	private ArticalService articalService;
	@Resource
	private UserService userService;
	
	@Action(value="introduction_show",results={
			@Result(name="success",location = "/WEB-INF/content/service_introduction_show.jsp")})
	public String execute(){
		introduction=introductionService.findById(1);
		int access=Integer.parseInt(introduction.getAccess()==null?"0":introduction.getAccess());
		introduction.setAccess(String.valueOf(++access));
		introductionService.merge(introduction);
		sessionRecord=counterSessionDAO.findAll().size()==0?1:counterSessionDAO.findAll().size();
		
		
		listComments=new ArrayList<Comments>();
		listComments=commentsService.findAll();
		listCommentsDTO=new ArrayList<CommentsDTO>();
//		Comments commentsTemp=new Comments();
//		CommentsDTO commentsDTOTemp=new CommentsDTO();
		for(int i=0;i<listComments.size();i++){
			Comments commentsTemp=new Comments();
			CommentsDTO commentsDTOTemp=new CommentsDTO();
			commentsTemp=listComments.get(i);
			commentsDTOTemp.setId(commentsTemp.getId());
			
			if (commentsTemp.getArticalid() != 0) {
				commentsDTOTemp.setArtical(articalService.findById(commentsTemp
						.getArticalid()));
			} else {
				Artical articalTemp = new Artical();
				articalTemp.setId(0);
				articalTemp.setTitle("Ö÷Ò³¾ý");
				commentsDTOTemp.setArtical(articalTemp);
			}
			
			//commentsDTOTemp.setArtical(articalService.findById(commentsTemp.getArticalid()));
			commentsDTOTemp.setContent(commentsTemp.getContent());
			commentsDTOTemp.setTime(commentsTemp.getTime());
			
			if (commentsTemp.getUserid() != 0) {
				commentsDTOTemp.setUser(userService.findById(commentsTemp
						.getUserid()));
			} else {
				User userTemp = new User();
				userTemp.setId(0);
				userTemp.setName("ÓÎ¿Í");
				commentsDTOTemp.setUser(userTemp);
			}
			//commentsDTOTemp.setUser(userService.findById(commentsTemp.getUserid()));
			listCommentsDTO.add(commentsDTOTemp);
		}
		
		
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
	public CommentsService getCommentsService() {
		return commentsService;
	}
	public void setCommentsService(CommentsService commentsService) {
		this.commentsService = commentsService;
	}
	public List<Comments> getListComments() {
		return listComments;
	}
	public void setListComments(List<Comments> listComments) {
		this.listComments = listComments;
	}
	public List<CommentsDTO> getListCommentsDTO() {
		return listCommentsDTO;
	}
	public void setListCommentsDTO(List<CommentsDTO> listCommentsDTO) {
		this.listCommentsDTO = listCommentsDTO;
	}
	public ArticalService getArticalService() {
		return articalService;
	}
	public void setArticalService(ArticalService articalService) {
		this.articalService = articalService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
