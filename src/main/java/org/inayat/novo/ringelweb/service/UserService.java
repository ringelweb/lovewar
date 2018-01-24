package org.inayat.novo.ringelweb.service;

import java.util.List;

import org.inayat.novo.ringelweb.model.FaqModel;
import org.inayat.novo.ringelweb.model.GfBfDataModel;
import org.inayat.novo.ringelweb.model.MessageModel;
import org.inayat.novo.ringelweb.model.UserModel;

public interface UserService {
	
    UserModel doLogin(UserModel user);
	UserModel doRegister(UserModel user);
	String getPassword(String secretans, String secretans2);
	public GfBfDataModel doSaveGfBfData(GfBfDataModel data);
	List<FaqModel> getFaqService();
	MessageModel sendMessage(MessageModel message);
}
