package com.jjweb.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jjweb.model.Artical;
@Entity
@Table(name = "category", catalog = "test")
public class Category {
	private int id;
	private String name;
	private Set<Artical> articals;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "name", nullable = false, length = 255)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy="category",cascade=CascadeType.REMOVE)
	public Set<Artical> getArticals() {
		return articals;
	}
	public void setArticals(Set<Artical> articals) {
		this.articals = articals;
	}
}
