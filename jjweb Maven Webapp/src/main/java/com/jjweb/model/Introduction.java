package com.jjweb.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Introduction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "introduction", catalog = "jjweb")
public class Introduction extends AbstractIntroduction implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Introduction() {
	}

	/** full constructor */
	public Introduction(String content, Timestamp time) {
		super(content, time);
	}

}
