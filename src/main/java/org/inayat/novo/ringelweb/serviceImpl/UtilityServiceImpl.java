package org.inayat.novo.ringelweb.serviceImpl;

import org.inayat.novo.ringelweb.dao.UtilityDao;
import org.inayat.novo.ringelweb.daoImpl.UtilityDaoImpl;
import org.inayat.novo.ringelweb.model.HelpTextModel;
import org.inayat.novo.ringelweb.service.UtilityService;

public class UtilityServiceImpl implements UtilityService {

	@Override
	   public HelpTextModel getHelpText() {
		UtilityDao dao=new UtilityDaoImpl();
	HelpTextModel helptext	=dao.getHelpText();
	return helptext;
	}

}
