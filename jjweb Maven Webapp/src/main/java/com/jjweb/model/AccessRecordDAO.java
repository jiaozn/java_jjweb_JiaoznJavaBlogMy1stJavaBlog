package com.jjweb.model;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AccessRecordDAO extends HibernateDaoSupport{
	private static final Logger log = LoggerFactory
			.getLogger(AccessRecordDAO.class);
	// property constants
	public static final String CONTENT = "content";

		protected void initDao() {
			// do nothing
		}
		public void save(AccessRecord transientInstance) {
			log.debug("saving AccessRecord instance");
			try {
				getHibernateTemplate().save(transientInstance);
				log.debug("save successful");
			} catch (RuntimeException re) {
				log.error("save failed", re);
				throw re;
			}
		}

//		public void delete(Artical persistentInstance) {
//			log.debug("deleting Introduction instance");
//			try {
//				getHibernateTemplate().delete(persistentInstance);
//				log.debug("delete successful");
//			} catch (RuntimeException re) {
//				log.error("delete failed", re);
//				throw re;
//			}
//		}
//
//		public Artical findById(java.lang.Integer id) {
//			log.debug("getting Artical instance with id: " + id);
//			try {
//				Artical instance = (Artical) getHibernateTemplate().get(
//						"com.jjweb.model.Artical", id);
//				return instance;
//			} catch (RuntimeException re) {
//				log.error("get failed", re);
//				throw re;
//			}
//		}

		public List<AccessRecord> findByExample(AccessRecord instance) {
			log.debug("finding AccessRecord instance by example");
			try {
				List<AccessRecord> results = (List<AccessRecord>) getHibernateTemplate()
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
			log.debug("finding AccessRecord instance with property: "
					+ propertyName + ", value: " + value);
			try {
				String queryString = "from AccessRecord as model where model."
						+ propertyName + "= ?";
				return getHibernateTemplate().find(queryString, value);
			} catch (RuntimeException re) {
				log.error("find by property name failed", re);
				throw re;
			}
		}

		public List<AccessRecord> findByContent(Object content) {
			return findByProperty(CONTENT, content);
		}

		public List findAll() {
			log.debug("finding all AccessRecord instances");
			try {
				String queryString = "from Artical";
				return getHibernateTemplate().find(queryString);
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
		}

//		public Artical merge(Artical detachedInstance) {
//			log.debug("merging Artical instance");
//			try {
//				Artical result = (Artical) getHibernateTemplate().merge(
//						detachedInstance);
//				log.debug("merge successful");
//				return result;
//			} catch (RuntimeException re) {
//				log.error("merge failed", re);
//				throw re;
//			}
//		}

//		public void attachDirty(Artical instance) {
//			log.debug("attaching dirty Artical instance");
//			try {
//				getHibernateTemplate().saveOrUpdate(instance);
//				log.debug("attach successful");
//			} catch (RuntimeException re) {
//				log.error("attach failed", re);
//				throw re;
//			}
//		}
//
//		public void attachClean(Artical instance) {
//			log.debug("attaching clean Artical instance");
//			try {
//				getHibernateTemplate().lock(instance, LockMode.NONE);
//				log.debug("attach successful");
//			} catch (RuntimeException re) {
//				log.error("attach failed", re);
//				throw re;
//			}
//		}

		public static AccessRecordDAO getFromApplicationContext(
				ApplicationContext ctx) {
			return (AccessRecordDAO) ctx.getBean("AccessRecordDAO");
		}
}
