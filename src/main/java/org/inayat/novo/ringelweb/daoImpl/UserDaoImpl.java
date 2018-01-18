package org.inayat.novo.ringelweb.daoImpl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import org.inayat.novo.ringelweb.dao.UserDao;
import org.inayat.novo.ringelweb.model.UserModel;

public class UserDaoImpl implements UserDao {

	/*
	 * public UserModel doSave(UserModel model) {
	 * System.out.println("Entered in userDaoImpl:doSave."); try { Connection con =
	 * DBConnection.connect(); PreparedStatement stmt = con.prepareStatement(
	 * "insert into user(first_name,last_name,username,password,email,mobile,usertype) values(?,?,?,?,?,?,?)"
	 * ); stmt.setString(1, model.getFname()); stmt.setString(2, model.getLname());
	 * stmt.setString(3, model.getUsername()); stmt.setString(4,
	 * model.getPassword()); stmt.setString(5, model.getEmail()); stmt.setString(6,
	 * model.getMobile()); stmt.setString(7, model.getUserType());
	 * 
	 * int i = stmt.executeUpdate(); if (i > 0) { model.setReturnedMsg("success");
	 * model.setException("No Exception"); } con.close(); return model; } catch
	 * (Exception e) { System.out.println(e);
	 * model.setException("Exception occur in Signup::" + e.toString()); }
	 * model.setReturnedMsg("Somethiing wrong saving DATA......"); return model;
	 * 
	 * }
	 */
	@Override
	public UserModel doAuthenticate(UserModel userModel) {
		String userid = userModel.getUsername();
		String password = userModel.getPassword();
		/*
		 * try { String query = "select *FROM user WHERE (username='" + userid +
		 * "' OR mobile='" + userid + "' OR email='" + userid + "') AND password='" +
		 * password + "'"; Statement st = con.createStatement(); ResultSet rs =
		 * st.executeQuery(query); if (rs.next()) { con.close(); return "success"; }
		 * else { con.close(); return "failed"; } } catch (Exception e) {
		 * e.printStackTrace(); } return null;
		 */

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(UserModel.class).buildSessionFactory();
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			String hql = "select user.id from user_table user where user.username=:username or user.email=:email or user.mobile=:mobile and user.password=:password";
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setParameter("username", userModel.getUsername());
			query.setParameter("email", userModel.getEmail());
			query.setParameter("mobile", userModel.getMobile());
			query.setParameter("password", userModel.getPassword());
			List result = query.list();
			System.out.println("resultset:" + result);
			
		  
			if (result.size() > 0) {
			int id =(int)result.get(0);
			userModel=	getUserDataByUserId(id);
			userModel.setSuccess(true);
			 return userModel;
		} 
			}catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
				return userModel;
			}
		} finally {
			session.close();
		}
		userModel.setReturnedMsg("wrong username");
		userModel.setSuccess(false);
		return userModel;
	}

	public UserModel doSave(UserModel model) {
		System.out.println("Entered in userDaoImpl:doSave.");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		try {
			session.save(model);
			session.getTransaction().commit();
			model.setSuccess(true);
		} catch (Exception e) {
			model.setSuccess(false);
			model.setException(e.toString());
			model.setReturnedMsg("Error Saving Data");
		} finally {
			session.close();
			factory.close();
		}
		return model;

	}

	@Override
	public UserModel getUserDataByUserId(int id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		UserModel model = new UserModel();
		try {
			session.beginTransaction();

			String hql = "from user_table where id = :id";
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			//List result = query.list();
		   List<UserModel> list=query.list();
			/*
			System.out.println("resultset:" + result);
			model.setId((int) result.get(0));
			model.setFname((String) result.get(1));
			model.setLname((String) result.get(2));
			model.setUsername((String) result.get(3));
			model.setPassword((String) result.get(4));
			model.setEmail((String) result.get(5));
			model.setMobile((String) result.get(6));
			model.setFeedback((String) result.get(7));
			model.setUserType((String) result.get(8));
			model.setReturnedMsg((String) result.get(9));
			model.setException((String) result.get(10));
			model.setCreatedon((Date) result.get(10));*/
		   return list.get(0);

		} catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
				model.setException(e.toString());
				model.setReturnedMsg("Error getting result");
				return model;
			}
		} finally {
			session.close();
		}
		return model;
	}

}
