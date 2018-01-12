package org.inayat.novo.ringelweb.serviceImpl;

import org.inayat.novo.ringelweb.dao.UserDao;
import org.inayat.novo.ringelweb.daoImpl.UserDaoImpl;
import org.inayat.novo.ringelweb.model.UserModel;
import org.inayat.novo.ringelweb.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public UserModel doRegister(UserModel user) {
		System.out.println("Entered in userSignUpServiceImpl:doRegister.");
		UserModel model=new UserModel();
	    UserDao dao=new UserDaoImpl();
		model.setFname(user.getFname());
		model.setLname(user.getLname());
		model.setUsername(user.getUsername());
		model.setPassword(user.getPassword());
		model.setEmail(user.getEmail());
		model.setMobile(user.getMobile());
		model.setUserMessage(user.getUserMessage());
		model.setException(user.getException());
		model.setUserType(user.getUserType());
		model.setFeedback(user.getFeedback());
	    model=dao.doSave(model);
		return model;
	}

	@Override
	public UserModel doLogin(UserModel user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
