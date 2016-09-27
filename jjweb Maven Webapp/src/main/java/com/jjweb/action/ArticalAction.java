package com.jjweb.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.jjweb.model.AccessRecord;
import com.jjweb.model.AccessRecordDAO;
import com.jjweb.model.Artical;
import com.jjweb.model.Category;
import com.jjweb.service.ArticalService;
import com.jjweb.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;

public class ArticalAction extends ActionSupport implements ServletRequestAware , ServletContextAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private ArticalService articalService;
	@Resource
	private CategoryService categoryService;
	private Artical artical;
	private Category category;
	private List<Category> categories;

	List<Artical> listArtical;
	
	//private HttpServletRequest httpServletRequest;
    //private HttpSession session;
    //private ServletContext application;
	
	private HttpServletRequest request;

    private ServletContext servletContext;

    private HttpServletResponse response;
	
	
    private AccessRecord accessRecord;
    @Resource
    private AccessRecordDAO accessRecordDAO;
    
    
	@Action(value="artical_showAll",results={
			@Result(name="success",location = "/WEB-INF/content/study_artical_showAll.jsp")})
	public String execute(){
		listArtical=new ArrayList<Artical>();
		listArtical=articalService.findAll();
		return SUCCESS;
	}
	@Action(value="artical_show",results={
			@Result(name="success",location = "/WEB-INF/content/study_artical_show.jsp")})
	public String artical_show(){
		System.out.println("artical_show action.if request exists:"+request.toString());
		
		artical=articalService.findById(artical.getId());
		int access=Integer.parseInt(artical.getAccess()==null?"0":artical.getAccess());
		artical.setAccess(String.valueOf(++access));
		articalService.merge(artical);
		
		String ip=request.getRemoteAddr()==null?"Ω‚Œˆ ß∞‹":request.getRemoteAddr();
		//request.getRequestURI()
		String destination=request.getRequestURI()==null?"Ω‚Œˆ ß∞‹":request.getRequestURI();
		String aintroduction=artical.getId()+" -- "+artical.getTitle();
		
		accessRecord=new AccessRecord();
		accessRecord.setIp(ip);
		accessRecord.setDestination(destination);
		accessRecord.setTime(new Timestamp(new Date().getTime()));
		accessRecordDAO.save(accessRecord);
		
		return SUCCESS;
	}
	@Action(value="artical_add",results={
			@Result(name="input",location = "/WEB-INF/content/study_artical_add.jsp")})
	public String artical_add(){
		categories=categoryService.findAll();
		return INPUT;
	}
	@Action(value="artical_addCommit",results={
			@Result(name="input",location = "/WEB-INF/content/study_artical_addCommit.jsp")})
	public String artical_addCommit(){
		artical.setTime(new Timestamp(new Date().getTime()));
		artical.setCategory(category);
		articalService.save(artical);
		return INPUT;
	}	
	@Action(value="artical_delete",results={
			@Result(name="success",location = "/WEB-INF/content/study_artical_deleteCommit.jsp")})
	public String artical_delete(){
		artical=articalService.findById(artical.getId());
		articalService.delete(artical);
		return SUCCESS;
	}
	@Action(value="artical_edit",results={
			@Result(name="success",location = "/WEB-INF/content/study_artical_edit.jsp")})
	public String artical_edit(){
		artical=articalService.findById(artical.getId());
		categories=categoryService.findAll();
		return SUCCESS;
	}
	@Action(value="artical_editCommit",results={
			@Result(name="success",location = "/WEB-INF/content/study_artical_editCommit.jsp")})
	public String artical_editCommit(){
		artical.setTime(new Timestamp(new Date().getTime()));
		artical.setCategory(category);
		articalService.merge(artical);
		return SUCCESS;
	}
	public ArticalService getArticalService() {
		return articalService;
	}
	public void setArticalService(ArticalService articalService) {
		this.articalService = articalService;
	}
	public Artical getArtical() {
		return artical;
	}
	public void setArtical(Artical artical) {
		this.artical = artical;
	}
	public List<Artical> getListArtical() {
		return listArtical;
	}
	public void setListArtical(List<Artical> listArtical) {
		this.listArtical = listArtical;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public AccessRecord getAccessRecord() {
		return accessRecord;
	}
	public void setAccessRecord(AccessRecord accessRecord) {
		this.accessRecord = accessRecord;
	}
	public AccessRecordDAO getAccessRecordDAO() {
		return accessRecordDAO;
	}
	public void setAccessRecordDAO(AccessRecordDAO accessRecordDAO) {
		this.accessRecordDAO = accessRecordDAO;
	}
	
	 public void setServletRequest(HttpServletRequest req) {

	        this.request=req;

	    }

	    public void setServletResponse(HttpServletResponse res) {

	        this.response=res;

	    }

	    public void setServletContext(ServletContext ser) {

	        this.servletContext=ser;

	    }
}
