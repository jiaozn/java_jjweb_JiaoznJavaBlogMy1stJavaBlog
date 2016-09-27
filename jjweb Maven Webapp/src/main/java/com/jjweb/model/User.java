package com.jjweb.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "jjweb")
public class User {
	
	private int id;
	private String name;
	private String password;
	private int age;
	private int sex;
	private String email;
	private String address;
	private String qq;
	private String pintroduction;
	private int authority;
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
	@Column(name = "name", nullable = true,unique=true, length = 255)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "password", nullable = true, length = 255)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "age", nullable = true,length=255)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Column(name = "sex", nullable = true,length=255)
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	@Column(name = "email", nullable = true,length=255)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "address", nullable = true,length=255)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "qq", nullable = true,length=255)
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	@Column(name = "pintroduction", nullable = true,length=16777216)
	public String getPintroduction() {
		return pintroduction;
	}
	public void setPintroduction(String pintroduction) {
		this.pintroduction = pintroduction;
	}
	@Column(name = "authority", nullable = true,length=255)
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	@Column(name = "time", nullable = true,length=255)
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
}
