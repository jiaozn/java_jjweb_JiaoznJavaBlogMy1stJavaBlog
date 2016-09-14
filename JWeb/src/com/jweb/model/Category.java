package com.jweb.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
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
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@OneToMany(mappedBy="category")
		public Set<Artical> getArticals() {
			return articals;
		}
		public void setArticals(Set<Artical> articals) {
			this.articals = articals;
		}
}
