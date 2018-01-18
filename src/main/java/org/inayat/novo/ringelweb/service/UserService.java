package org.inayat.novo.ringelweb.service;

import org.inayat.novo.ringelweb.model.UserModel;

public interface UserService {
	
    UserModel doLogin(UserModel user);
	UserModel doRegister(UserModel user);
	String getPassword(String secretans, String secretans2);

}
