package com.jjweb.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CounterSessionDAO extends HibernateDaoSupport{
	private static final Logger log = LoggerFactory
			.getLogger(CounterSessionDAO.class);
	
	//sessionFactory=new org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean();
	protected void initDao() {
		// do nothing
	}
	public List findAll() {
		log.debug("finding all CounterSession instances");
		try {
			String queryString = "from CounterSession";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			System.out.println("find all failed");
			throw re;
		}
	}
	
	public void save(CounterSession transientInstance) {
		log.debug("saving CounterSession instance");
		System.out.println("counterSessionDAO-----"+transientInstance.getIp());
		if(transientInstance!=null)
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public static CounterSessionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CounterSessionDAO) ctx.getBean("CounterSessionDAO");
	}
}
