package com.adiwood.dao.implement;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.adiwood.dao.DaoStates;
import com.adiwood.entity.States;

/**
 * A data access object (DAO) providing persistence and search support for
 * States entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.adiwood.entity.States
 * @author MyEclipse Persistence Tools
 */
public class DaoStatesImplement extends HibernateDaoSupport implements DaoStates {
	private static final Logger log = LoggerFactory.getLogger(DaoStatesImplement.class);
	// property constants
	public static final String SNAME = "sname";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoStates#save(com.adiwood.entity.States)
	 */
	@Override
	public void save(States transientInstance) {
		log.debug("saving States instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoStates#delete(com.adiwood.entity.States)
	 */
	@Override
	public void delete(States persistentInstance) {
		log.debug("deleting States instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoStates#findById(java.lang.String)
	 */
	@Override
	public States findById(java.lang.String id) {
		log.debug("getting States instance with id: " + id);
		try {
			States instance = (States) getHibernateTemplate().get(
					"com.adiwood.entity.States", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoStates#findByExample(com.adiwood.entity.States)
	 */
	@Override
	public List findByExample(States instance) {
		log.debug("finding States instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoStates#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding States instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from States as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoStates#findBySname(java.lang.Object)
	 */
	@Override
	public List findBySname(Object sname) {
		return findByProperty(SNAME, sname);
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoStates#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all States instances");
		try {
			String queryString = "from States";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoStates#merge(com.adiwood.entity.States)
	 */
	@Override
	public States merge(States detachedInstance) {
		log.debug("merging States instance");
		try {
			States result = (States) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoStates#attachDirty(com.adiwood.entity.States)
	 */
	@Override
	public void attachDirty(States instance) {
		log.debug("attaching dirty States instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoStates#attachClean(com.adiwood.entity.States)
	 */
	@Override
	public void attachClean(States instance) {
		log.debug("attaching clean States instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DaoStates getFromApplicationContext(ApplicationContext ctx) {
		return (DaoStates) ctx.getBean("StatesDAO");
	}
}