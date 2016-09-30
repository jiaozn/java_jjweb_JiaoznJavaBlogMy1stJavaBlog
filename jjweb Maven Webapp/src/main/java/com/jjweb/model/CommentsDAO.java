package com.jjweb.model;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


	public class CommentsDAO extends HibernateDaoSupport{
		private static final Logger log = LoggerFactory
				.getLogger(CommentsDAO.class);
		// property constants
		public static final String CONTENT = "content";

			protected void initDao() {
				// do nothing
			}
			public void save(Comments transientInstance) {
				log.debug("saving Comments instance");
				try {
					getHibernateTemplate().save(transientInstance);
					log.debug("save successful");
				} catch (RuntimeException re) {
					log.error("save failed", re);
					throw re;
				}
			}

			public void delete(Comments persistentInstance) {
				log.debug("deleting Comments instance");
				try {
					getHibernateTemplate().delete(persistentInstance);
					log.debug("delete successful");
				} catch (RuntimeException re) {
					log.error("delete failed", re);
					throw re;
				}
			}

			public List findAll() {
				log.debug("finding all Comments instances");
				try {
					String queryString = "from Comments";
					return getHibernateTemplate().find(queryString);
				} catch (RuntimeException re) {
					log.error("find all failed", re);
					throw re;
				}
			}

			public Comments merge(Comments detachedInstance) {
				log.debug("merging Comments instance");
				try {
					Comments result = (Comments) getHibernateTemplate().merge(
							detachedInstance);
					log.debug("merge successful");
					return result;
				} catch (RuntimeException re) {
					log.error("merge failed", re);
					throw re;
				}
			}
			public Comments findById(java.lang.Integer id) {
				log.debug("getting Comments instance with id: " + id);
				try {
					Comments instance = (Comments) getHibernateTemplate().get(
							"com.jjweb.model.Comments", id);
					return instance;
				} catch (RuntimeException re) {
					log.error("get failed", re);
					throw re;
				}
			}
			
			public List findByArticalId(int id){
				log.debug("finding Comments by articalId");
				try {
					//String queryString = "from Comments";
					return getHibernateTemplate().find("from Comments c where c.articalid=?", id);
				} catch (RuntimeException re) {
					log.error("find failed", re);
					throw re;
				}
			}
			
			public static CommentsDAO getFromApplicationContext(
					ApplicationContext ctx) {
				return (CommentsDAO) ctx.getBean("CommentsDAO");
			}
	}


