package com.jjweb.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jjweb.model.Artical;
import com.jjweb.model.Category;
import com.jjweb.model.IntroductionDAO;
import com.jjweb.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport{
	@Resource
	private CategoryService categoryService;
	private static final Logger log = LoggerFactory
			.getLogger(IntroductionDAO.class);
	private Category category;
	List<Category> listCategory;
	private List<Artical> articals;
	@Action(value="category_showAll",results={
			@Result(name="success",location = "/WEB-INF/content/study_category_showAll.jsp")})
	public String execute(){
		listCategory=new ArrayList<Category>();
		listCategory=categoryService.findAll();
		return "success";
	}
	@Action(value="category_show",results={
			@Result(name="success",location = "/WEB-INF/content/study_category_show.jsp")})
	public String category_show(){
		category=categoryService.findById(category.getId());
		return "success";
	}
	@Action(value="category_add",results={
			@Result(name="input",location = "/WEB-INF/content/study_category_add.jsp")})
	public String category_add(){
		
		return INPUT;
	}
	@Action(value="category_addCommit",results={
			@Result(name="success",location = "/WEB-INF/content/study_category_addCommit.jsp")})
	public String category_addCommit(){
		category.setArticals(null);
		categoryService.save(category);
		return SUCCESS;
	}
	@Action(value="category_delete",results={
			@Result(name="success",location = "/WEB-INF/content/study_category_deleteCommit.jsp")})
	public String category_delete(){
		category=categoryService.findById(category.getId());
		categoryService.delete(category);
		return SUCCESS;
	}
	@Action(value="category_edit",results={
			@Result(name="success",location = "/WEB-INF/content/study_category_edit.jsp")})
	public String category_edit(){
		category=categoryService.findById(category.getId());
		return SUCCESS;
	}
	@Action(value="category_editCommit",results={
			@Result(name="success",location = "/WEB-INF/content/study_category_editCommit.jsp")})
	public String category_editCommit(){
		categoryService.merge(category);
		return SUCCESS;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	public List<Artical> getArticals() {
		return articals;
	}
	public void setArticals(List<Artical> articals) {
		this.articals = articals;
	}
}
