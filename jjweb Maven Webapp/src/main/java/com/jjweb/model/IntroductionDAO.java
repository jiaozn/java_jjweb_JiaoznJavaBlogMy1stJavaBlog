package com.jjweb.model;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Introduction entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jjweb.model.Introduction
 * @author MyEclipse Persistence Tools
 */
public class IntroductionDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(IntroductionDAO.class);
	// property constants
	public static final String CONTENT = "content";

	protected void initDao() {
		// do nothing
	}

	public void save(Introduction transientInstance) {
		log.debug("saving Introduction instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Introduction persistentInstance) {
		log.debug("deleting Introduction instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Introduction findById(java.lang.Integer id) {
		log.debug("getting Introduction instance with id: " + id);
		try {
			Introduction instance = (Introduction) getHibernateTemplate().get(
					"com.jjweb.model.Introduction", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Introduction> findByExample(Introduction instance) {
		log.debug("finding Introduction instance by example");
		try {
			List<Introduction> results = (List<Introduction>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Introduction instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Introduction as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Introduction> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all Introduction instances");
		try {
			String queryString = "from Introduction";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Introduction merge(Introduction detachedInstance) {
		log.debug("merging Introduction instance");
		try {
			Introduction result = (Introduction) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Introduction instance) {
		log.debug("attaching dirty Introduction instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Introduction instance) {
		log.debug("attaching clean Introduction instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IntroductionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IntroductionDAO) ctx.getBean("IntroductionDAO");
	}
}