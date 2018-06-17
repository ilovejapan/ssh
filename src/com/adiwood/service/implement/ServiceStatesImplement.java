package com.adiwood.service.implement;

import java.util.List;

import com.adiwood.dao.DaoStates;
import com.adiwood.entity.Entity;
import com.adiwood.service.ServiceStates;

public class ServiceStatesImplement implements ServiceStates {
	
	DaoStates sd;

	public DaoStates getSd() {
		return sd;
	}
	public void setSd(DaoStates sd) {
		this.sd = sd;
	}

	
	@Override
	public Entity loadStates(Entity entity) {
		// TODO Auto-generated method stub
		
		List<Object> list = sd.findAll();
		
		entity.setList(list);
		
		return entity;
	}

}
