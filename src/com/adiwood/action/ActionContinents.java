package com.adiwood.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.adiwood.entity.Continentss;
import com.adiwood.entity.Entity;
import com.adiwood.service.ServiceContinents;

public class ActionContinents {
	
	Continentss continents;
	ServiceContinents cs;
	String string;
	
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public ServiceContinents getCs() {
		return cs;
	}
	public void setCs(ServiceContinents cs) {
		this.cs = cs;
	}
	public Continentss getContinents() {
		return continents;
	}
	public void setContinents(Continentss continents) {
		this.continents = continents;
	}

	
	public String postContinents(){
		
		Entity entity = new Entity();
		
		entity.setObject(continents);
		
		entity = cs.loadContinents(entity);
		
		JSONArray array = new JSONArray();
		
		List<Object> list = entity.getList();
		
		for (int i = 0; i < list.size(); i++) {
			
			Continentss c = (Continentss) list.get(i);
			
//			System.out.println(c.getCid());
//			System.out.println(c.getCname());
			
			JSONObject object = new JSONObject();
			
			object.put("cid", c.getCid());
			object.put("cname", c.getCname());
			
			array.add(object);// jsonArray only for jsonObject
		}
		
//		System.out.println(array.toString());
		
		string = array.toString();
		
		return "continents";
	}

}
