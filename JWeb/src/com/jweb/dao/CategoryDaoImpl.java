package com.jweb.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.jweb.model.Category;
import com.jweb.util.HibernateUtils;

@Component
public class CategoryDaoImpl implements CategoryDao{
	Category category;
	
	SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
	public Category getById(int id){
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		category=(Category)session.get(Category.class, id);
		session.getTransaction().commit();
		return category;
	}
//	public void updateArticalDao(
//			Artical artical) {
//		Session session=sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		session.update(artical);
//		session.getTransaction().commit();
//	}
//	public Artical getArtical() {
//		return artical;
//	}
//	public void setArtical(Artical artical) {
//		this.artical = artical;
//	}
//	public void addArtical(Artical artical) {
//		// TODO Auto-generated method stub
//		Session session=sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		session.save(artical);
//		session.getTransaction().commit();
//	}
}
