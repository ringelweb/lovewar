package org.inayat.novo.ringelweb.dao;

import org.inayat.novo.ringelweb.model.UserModel;

public  interface UserDao {
	
	public UserModel doSave(UserModel model);

	public UserModel doAuthenticate(UserModel userModel);
	

	public UserModel getUserDataByUserId(int id);
	
	
	
}
