package com.adiwood.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.adiwood.entity.Areas;
import com.adiwood.entity.Entity;
import com.adiwood.service.ServiceAreas;

public class ActionAreas {
	
	Areas areas;
	ServiceAreas as;
	String string;
	
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public ServiceAreas getAs() {
		return as;
	}
	public void setAs(ServiceAreas as) {
		this.as = as;
	}
	public Areas getAreas() {
		return areas;
	}
	public void setAreas(Areas areas) {
		this.areas = areas;
	}

	public String postAreas(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String sid = request.getParameter("sid");
		
//		System.out.println("sid is "+sid);
		
		Entity entity = new Entity();
		
		entity.setObject(areas);
		
		entity = as.loadAreas(entity);
		
		JSONArray array = new JSONArray();
		
		List<Object> list = entity.getList();
		
		for (int i = 0; i < list.size(); i++) {
			
			Areas a = (Areas) list.get(i);
			
//			System.out.println(a.getAid());
//			System.out.println(a.getAname());
			
			if(a.getStates().getSid().equals(sid)){
				
				JSONObject object = new JSONObject();
				
				object.put("aid", a.getAid());
				object.put("aname", a.getAname());
				
				array.add(object);
			}		
		}
		
//		System.out.println(array.toString());
		
		string = array.toString();
		
		return "areas";
	}

}
