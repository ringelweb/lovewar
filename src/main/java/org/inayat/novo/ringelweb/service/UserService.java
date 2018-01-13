package org.inayat.novo.ringelweb.service;

import org.inayat.novo.ringelweb.model.UserModel;

public interface UserService {
	

    String doLogin(UserModel user);
	UserModel doRegister(UserModel user);

}
