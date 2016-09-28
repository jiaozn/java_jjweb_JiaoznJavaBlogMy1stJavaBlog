package com.jjweb.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "comments", catalog = "jjweb")
public class Comments {
	
	private int id;
	private String content;
	private int userid;
	private int articalid;
	private Timestamp time;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "content", nullable = true, length=16777216)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "userid", nullable = true, length = 255)
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Column(name = "articalid", nullable = true, length = 255)
	public int getArticalid() {
		return articalid;
	}
	
	public void setArticalid(int articalid) {
		this.articalid = articalid;
	}
	@Column(name = "time", nullable = true, length = 255)
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
}
