package org.inayat.novo.ringelweb.dao;

import org.inayat.novo.ringelweb.model.CelebrationModel;
import org.inayat.novo.ringelweb.model.HelpTextModel;

public interface UtilityDao {
	
public HelpTextModel getHelpText();

public CelebrationModel getCelebrationDetails(String string) ;

}
