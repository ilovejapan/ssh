package com.adiwood.service.implement;

import com.adiwood.dao.DaoUser;
import com.adiwood.entity.Entity;
import com.adiwood.entity.Users;
import com.adiwood.service.ServiceUser;

public class ServiceUserImplement implements ServiceUser {
	
	DaoUser ud;

	public DaoUser getUd() {
		return ud;
	}
	public void setUd(DaoUser ud) {
		this.ud = ud;
	}

	
	@Override
	public Entity loadUser(Entity entity) {
		// TODO Auto-generated method stub
		
		Users userInput = (Users) entity.getObject();
		
		String usernameInput = userInput.getUsername();
		String passwordInput = userInput.getPassword();
		
		Users userDatabase = ud.findById(usernameInput);
		
		if(userDatabase != null){
			if(userDatabase.getPassword().equals(passwordInput)){
				entity.setObject(userDatabase);
				entity.setFlag(true);
				entity.setMessage("Login success");
			}else{
				entity.setFlag(false);
				entity.setMessage("Password isn't correct");
			}
		}else{
			entity.setFlag(false);
			entity.setMessage("Username doesn't exist");
		}
		
		return entity;
	}

}
