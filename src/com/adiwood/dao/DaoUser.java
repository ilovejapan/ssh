package com.adiwood.dao;

import java.util.List;

import com.adiwood.entity.Users;

public interface DaoUser {

	public abstract void save(Users transientInstance);

	public abstract void delete(Users persistentInstance);

	public abstract Users findById(java.lang.String id);

	public abstract List findByExample(Users instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPassword(Object password);

	public abstract List findAll();

	public abstract Users merge(Users detachedInstance);

	public abstract void attachDirty(Users instance);

	public abstract void attachClean(Users instance);

}