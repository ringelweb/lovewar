package org.inayat.novo.ringelweb.service;

import java.text.ParseException;
import java.util.Date;

import org.inayat.novo.ringelweb.model.CelebrationModel;
import org.inayat.novo.ringelweb.model.HelpTextModel;

public interface UtilityService {
	public HelpTextModel getHelpText();

	public CelebrationModel getCelebration() throws ParseException;
	String parseDate(Date date);

}
