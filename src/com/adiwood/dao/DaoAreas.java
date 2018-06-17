package com.adiwood.dao;

import java.util.List;

import com.adiwood.entity.Areas;

public interface DaoAreas {

	public abstract void save(Areas transientInstance);

	public abstract void delete(Areas persistentInstance);

	public abstract Areas findById(java.lang.String id);

	public abstract List findByExample(Areas instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByAname(Object aname);

	public abstract List findAll();

	public abstract Areas merge(Areas detachedInstance);

	public abstract void attachDirty(Areas instance);

	public abstract void attachClean(Areas instance);

}