package com.adiwood.service.implement;

import java.util.List;

import com.adiwood.dao.DaoAreas;
import com.adiwood.entity.Entity;
import com.adiwood.service.ServiceAreas;

public class ServiceAreasImplement implements ServiceAreas {
	
	DaoAreas ad;

	public DaoAreas getAd() {
		return ad;
	}
	public void setAd(DaoAreas ad) {
		this.ad = ad;
	}

	
	@Override
	public Entity loadAreas(Entity entity) {
		// TODO Auto-generated method stub
		
		List<Object> list = ad.findAll();
		
		entity.setList(list);
		
		return entity;
	}

}
