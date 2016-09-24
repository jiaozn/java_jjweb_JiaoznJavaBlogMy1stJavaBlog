package com.jjweb.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jjweb.model.Artical;
import com.jjweb.model.Category;
import com.jjweb.service.ArticalService;
import com.jjweb.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;

public class ArticalAction extends ActionSupport{
	@Resource
	private ArticalService articalService;
	@Resource
	private CategoryService categoryService;
	private Artical artical;
	private Category category;
	private List<Category> categories;

	List<Artical> listArtical;
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
		artical=articalService.findById(artical.getId());
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
		return SUCCESS;
	}
	@Action(value="artical_editCommit",results={
			@Result(name="success",location = "/WEB-INF/content/study_artical_editCommit.jsp")})
	public String artical_editCommit(){
		artical.setTime(new Timestamp(new Date().getTime()));
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
}
