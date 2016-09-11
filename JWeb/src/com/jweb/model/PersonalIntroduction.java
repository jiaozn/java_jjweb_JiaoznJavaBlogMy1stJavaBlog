package com.jweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class PersonalIntroduction {
	
	private int id;
	private String content;
	private Date date;
	public String getContent() {
		return content;
	}
	public Date getDate() {
		return date;
	}
	@Id
	public int getId() {
		return id;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setId(int id) {
		this.id = id;
	}
}
