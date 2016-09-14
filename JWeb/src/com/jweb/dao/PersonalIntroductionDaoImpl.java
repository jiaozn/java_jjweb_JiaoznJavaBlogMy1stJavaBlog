package com.jweb.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.jweb.model.PersonalIntroduction;
import com.jweb.util.HibernateUtils;

@Component
public class PersonalIntroductionDaoImpl implements PersonalIntroductionDao{
	PersonalIntroduction personalIntroduction;
	
	SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
	public PersonalIntroduction getById(int id){
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		personalIntroduction=(PersonalIntroduction)session.get(PersonalIntroduction.class, id);
		session.getTransaction().commit();
		return personalIntroduction;
	}
	public PersonalIntroduction getPersonalIntroduction() {
		return personalIntroduction;
	}
	public void setPersonalIntroduction(PersonalIntroduction personalIntroduction) {
		this.personalIntroduction = personalIntroduction;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	//@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void updatePersonalIntroductionDao(
			PersonalIntroduction personalIntroduction) {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(personalIntroduction);
		session.getTransaction().commit();
	}
}
