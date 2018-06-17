package com.adiwood.service.implement;

import java.util.List;

import com.adiwood.dao.DaoContinents;
import com.adiwood.entity.Continentss;
import com.adiwood.entity.Entity;
import com.adiwood.service.ServiceContinents;

public class ServiceContinentsImplement implements ServiceContinents {
	
	DaoContinents cd;

	public DaoContinents getCd() {
		return cd;
	}
	public void setCd(DaoContinents cd) {
		this.cd = cd;
	}

	
	@Override
	public Entity loadContinents(Entity entity) {
		// TODO Auto-generated method stub
		
		List<Object> list = cd.findAll();
		
		entity.setList(list);
		
		return entity;
	}

}
