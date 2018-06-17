package com.adiwood.dao.implement;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.adiwood.dao.DaoContinents;
import com.adiwood.entity.Continentss;

/**
 * A data access object (DAO) providing persistence and search support for
 * Continentss entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.adiwood.entity.Continentss
 * @author MyEclipse Persistence Tools
 */
public class DaoContinentsImplement extends HibernateDaoSupport implements DaoContinents {
	private static final Logger log = LoggerFactory
			.getLogger(DaoContinentsImplement.class);
	// property constants
	public static final String CNAME = "cname";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoContinents#save(com.adiwood.entity.Continentss)
	 */
	@Override
	public void save(Continentss transientInstance) {
		log.debug("saving Continentss instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoContinents#delete(com.adiwood.entity.Continentss)
	 */
	@Override
	public void delete(Continentss persistentInstance) {
		log.debug("deleting Continentss instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoContinents#findById(java.lang.String)
	 */
	@Override
	public Continentss findById(java.lang.String id) {
		log.debug("getting Continentss instance with id: " + id);
		try {
			Continentss instance = (Continentss) getHibernateTemplate().get(
					"com.adiwood.entity.Continentss", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoContinents#findByExample(com.adiwood.entity.Continentss)
	 */
	@Override
	public List findByExample(Continentss instance) {
		log.debug("finding Continentss instance by example");
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
	 * @see com.adiwood.entity.DaoContinents#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Continentss instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Continentss as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoContinents#findByCname(java.lang.Object)
	 */
	@Override
	public List findByCname(Object cname) {
		return findByProperty(CNAME, cname);
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoContinents#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Continentss instances");
		try {
			String queryString = "from Continentss";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoContinents#merge(com.adiwood.entity.Continentss)
	 */
	@Override
	public Continentss merge(Continentss detachedInstance) {
		log.debug("merging Continentss instance");
		try {
			Continentss result = (Continentss) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoContinents#attachDirty(com.adiwood.entity.Continentss)
	 */
	@Override
	public void attachDirty(Continentss instance) {
		log.debug("attaching dirty Continentss instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.adiwood.entity.DaoContinents#attachClean(com.adiwood.entity.Continentss)
	 */
	@Override
	public void attachClean(Continentss instance) {
		log.debug("attaching clean Continentss instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DaoContinents getFromApplicationContext(
			ApplicationContext ctx) {
		return (DaoContinents) ctx.getBean("ContinentssDAO");
	}
}