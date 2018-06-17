package com.adiwood.dao;

import java.util.List;

import com.adiwood.entity.Continentss;

public interface DaoContinents {

	public abstract void save(Continentss transientInstance);

	public abstract void delete(Continentss persistentInstance);

	public abstract Continentss findById(java.lang.String id);

	public abstract List findByExample(Continentss instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCname(Object cname);

	public abstract List findAll();

	public abstract Continentss merge(Continentss detachedInstance);

	public abstract void attachDirty(Continentss instance);

	public abstract void attachClean(Continentss instance);

}