package com.jjweb.model;

import java.sql.Timestamp;


public class CommentsDTO {
	
	private int id;
	private String content;
	private Timestamp time;
	
	private Artical artical;
	private User user;
	public Artical getArtical() {
		return artical;
	}
	public void setArtical(Artical artical) {
		this.artical = artical;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
//	public int getUserid() {
//		return userid;
//	}
//	public void setUserid(int userid) {
//		this.userid = userid;
//	}
//	public int getArticalid() {
//		return articalid;
//	}
//	public void setArticalid(int articalid) {
//		this.articalid = articalid;
//	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
}
