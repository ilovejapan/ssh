package com.adiwood.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.adiwood.entity.Entity;
import com.adiwood.entity.States;
import com.adiwood.service.ServiceStates;

public class ActionStates {
	
	States states;
	ServiceStates ss;
	String string;

	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public ServiceStates getSs() {
		return ss;
	}
	public void setSs(ServiceStates ss) {
		this.ss = ss;
	}
	public States getStates() {
		return states;
	}
	public void setStates(States states) {
		this.states = states;
	}


	public String postStates(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cid = request.getParameter("cid");
		
		Entity entity = new Entity();
		
		entity.setObject(states);
		
		entity = ss.loadStates(entity);
		
		JSONArray array = new JSONArray();
		
		List<Object> list = entity.getList();
		
		for (int i = 0; i < list.size(); i++) {
			
			States s = (States) list.get(i);
			
//			System.out.println(s.getSid());
//			System.out.println(s.getSname());
			
			JSONObject object = new JSONObject();
			
			if(s.getContinentss().getCid().equals(cid)){
				
				object.put("sid", s.getSid());
				object.put("sname", s.getSname());
				
				array.add(object);
			}
			
//			System.out.println(array.toString());
		}
		
		string = array.toString();
		
		return "states";
	}

}
