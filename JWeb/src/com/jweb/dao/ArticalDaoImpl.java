package com.jweb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.jweb.model.Artical;
import com.jweb.model.PersonalIntroduction;
import com.jweb.util.HibernateUtils;

@Component
public class ArticalDaoImpl implements ArticalDao{
	Artical artical;
	List<Artical> list_Artical;
	SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
	public Artical getById(int id){
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		artical=(Artical)session.get(Artical.class, id);
		session.getTransaction().commit();
		return artical;
	}
	public void updateArticalDao(
			Artical artical) {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		//session.update(artical);
		Query query = session.createQuery("update Artical art set art.title =:title,art.author=:author,art.category=:category,art.content=:content where id = :artid").setString("title", artical.getTitle()).setString("author", artical.getAuthor()).setString("content", artical.getContent()).setInteger("artid", artical.getId()).setParameter("category", artical.getCategory());  
        query.executeUpdate();  
		session.getTransaction().commit();
	}
	public Artical getArtical() {
		return artical;
	}
	public void setArtical(Artical artical) {
		this.artical = artical;
	}
	public void addArtical(Artical artical) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(artical);
		session.getTransaction().commit();
	}
	public List<Artical> listAll() {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		list_Artical=(List<Artical>) session.createQuery("from Artical").list();
	//	System.out.println(list_Artical.get(1).getContent());
		session.getTransaction().commit();
		return list_Artical;
	}
	public void deleteById(Artical artical) {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(artical);
		session.getTransaction().commit();
	}
}
