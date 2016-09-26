package com.jjweb.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "counterSession", catalog = "test")
public class CounterSession {
	private int id;
	private String ip;
	private Timestamp time;
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = true)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "ip", nullable = false, length = 255)
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Column(name = "time", nullable = false, length = 255)
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	

}
