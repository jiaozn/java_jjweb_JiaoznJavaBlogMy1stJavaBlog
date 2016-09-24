package com.jjweb.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jjweb.model.Category;
@Entity
@Table(name = "artical", catalog = "test")
public class Artical {
	private int id;
	private String title;
	private String content;
	private String author;
	private Timestamp time;
	private Category category;
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "title", nullable = false, length = 255)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "content", nullable = false,length=16777216)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "author", nullable = false, length = 255)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	@ManyToOne
	@JoinColumn
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
