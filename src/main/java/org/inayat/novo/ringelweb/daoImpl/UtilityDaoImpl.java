package org.inayat.novo.ringelweb.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.inayat.novo.ringelweb.dao.UtilityDao;
import org.inayat.novo.ringelweb.model.CelebrationModel;
import org.inayat.novo.ringelweb.model.HelpTextModel;

public class UtilityDaoImpl implements UtilityDao {

	@Override
	public HelpTextModel getHelpText() {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		HelpTextModel model = new HelpTextModel();
		try {
			session.beginTransaction();

			String hql = "from helpText_table";
			System.out.println(hql);
			Query query = session.createQuery(hql);
			// List result = query.list();
			List<HelpTextModel> list = query.list();
		    model=list.get(0);
		    model.setSuccess(true);
		    return model;
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
				model.setException(e.toString());
				model.setReturnedMsg("Error getting result");
				model.setSuccess(false);
				return model;
			}
		} finally {
			session.close();
		}
		return model;
	
	}
	
	@Override
	public CelebrationModel getCelebrationDetails(String currentDate) {
       // currentDate="2018-02-07";
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		CelebrationModel model = new CelebrationModel();
		try {
			session.beginTransaction();
			String hql = "from celebration_table where celebrationDayDate=:celebrationDayDate";
			System.out.println(hql);
			System.out.println(currentDate);
			
			Query query = session.createQuery(hql);
			query.setParameter("celebrationDayDate",currentDate);
			List<CelebrationModel> list = query.list();
			if(list.size()>0)
			model=list.get(0);
			else
			model.setReturnedMsg("No Celebration is Today");	
		    model.setSuccess(true);
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
				model.setException(e.toString());
				model.setSuccess(false);

			}
		} finally {
			session.close();
		}
		return model;
	
	}

}
