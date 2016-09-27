package com.jjweb.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractIntroduction entity provides the base persistence definition of the
 * Introduction entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractIntroduction implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private String access;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public AbstractIntroduction() {
	}

	/** full constructor */
	public AbstractIntroduction(String content, Timestamp time) {
		this.content = content;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "content", nullable = false, length=16777216)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	@Column(name = "access", nullable = true, length = 19)
	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

}