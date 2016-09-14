package com.jweb.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.jweb.dao.CategoryDaoImpl;
import com.jweb.model.Artical;
import com.jweb.service.ArticalService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArticalAction extends ActionSupport{
	
	private ArticalService articalService;
	private Artical artical;
	private int category_id;
	private int artical_id;
	private List<Artical> list_Artical;
	public String add(){
		return "add";
	}
	public String executeAdd(){
		//System.out.println("start adding...");
		artical.setDate(new Date());
		artical.setCategory(new CategoryDaoImpl().getById(category_id));
		//System.out.println(artical.getContent()+"00"+new CategoryDaoImpl().getById(category_id).getName());
		articalService.addArtical(artical);
		return "add_success";
	}
	public String listAll(){
		list_Artical=articalService.listAll();
	//	System.out.print("Action get"+list_Artical.size());
		Map request =(Map)ActionContext.getContext().get("request");
		request.put("list_Artical", list_Artical);
		return "list_all";
	}
	public String listArticalById(){
		artical=articalService.getArticalById(artical_id);
		Map request =(Map)ActionContext.getContext().get("request");
		request.put("artical", artical);
		return "show_artical";
	}
	public String editArtical(){
		artical=articalService.getArticalById(artical_id);
		Map request =(Map)ActionContext.getContext().get("request");
		request.put("artical", artical);
		return "edit_artical";

	}
	
	public String updateArticalById(){
		//System.out.println(artical.getAuthor()+"-------第一次print");
		artical_id=artical.getId();
		artical.setDate(new Date());
//		artical.setTitle(title);
//		artical.setAuthor(author);
//		artical.setCategory(category);
//		artical.setContent(content);
		articalService.updateArtical(artical);
		//System.out.println(artical_id);
		artical=articalService.getArticalById(artical_id);
		System.out.println(artical_id);
		//System.out.println(artical.getAuthor()+"-------第2次print");
		Map request =(Map)ActionContext.getContext().get("request");
		artical=articalService.getArticalById(artical_id);
		request.put("articalUpdated", artical);
		//System.out.println(artical.getAuthor()+"-------第3次print");
		//System.out.println(artical.getAuthor()+" and content = "+artical.getTitle());
		return "update_articalSuccess";
	}
	
	public String delete(Artical artical){
		return null;
	}
	
//	public String getById(){
//		return null;
//	}
//	
	public ArticalService getArticalService() {
		return articalService;
	}
	@Resource
	public void setArticalService(ArticalService articalService) {
		this.articalService = articalService;
	}

	public Artical getArtical() {
		return artical;
	}

	public void setArtical(Artical artical) {
		this.artical = artical;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public List<Artical> getList_Artical() {
		return list_Artical;
	}
	public void setList_Artical(List<Artical> list_Artical) {
		this.list_Artical = list_Artical;
	}
	public int getArtical_id() {
		return artical_id;
	}
	public void setArtical_id(int artical_id) {
		this.artical_id = artical_id;
	}

}
