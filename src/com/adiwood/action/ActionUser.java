package com.adiwood.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.adiwood.entity.Entity;
import com.adiwood.entity.Users;
import com.adiwood.service.ServiceUser;

public class ActionUser implements SessionAware {
	
	Users user;
	ServiceUser us;
	Map<String, Object> session;
	
	public ServiceUser getUs() {
		return us;
	}
	public void setUs(ServiceUser us) {
		this.us = us;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}

	
	public String postUser(){
		
		Entity entity = new Entity();
		
		entity.setObject(user);
		
		entity = us.loadUser(entity);
		
		if(entity.isFlag()){
			session.put("user", entity.getObject());
			session.put("message", entity.getMessage());
			
			return "success";
		}else{
			session.put("message", entity.getMessage());
			
			return "error";
		}
		
//		return null;
	}
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		session = map;
	}
}
