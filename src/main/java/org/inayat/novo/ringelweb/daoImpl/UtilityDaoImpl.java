package org.inayat.novo.ringelweb.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.inayat.novo.ringelweb.dao.UtilityDao;
import org.inayat.novo.ringelweb.model.HelpTextModel;
import org.inayat.novo.ringelweb.model.UserModel;

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
		} catch (HibernateException e) {
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

}
