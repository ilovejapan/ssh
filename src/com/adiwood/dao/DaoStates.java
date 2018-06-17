package com.adiwood.dao;

import java.util.List;

import com.adiwood.entity.States;

public interface DaoStates {

	public abstract void save(States transientInstance);

	public abstract void delete(States persistentInstance);

	public abstract States findById(java.lang.String id);

	public abstract List findByExample(States instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findBySname(Object sname);

	public abstract List findAll();

	public abstract States merge(States detachedInstance);

	public abstract void attachDirty(States instance);

	public abstract void attachClean(States instance);

}