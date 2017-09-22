package org.web.login.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.web.login.dto.User;

public class LoginService {
	private SessionFactory sessionFactory = null;

	public LoginService() throws Exception {
		try {
			this.sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch(Exception ex) {
			throw new Exception("Error encountered while attempting to initialize RegisterService.\n" + ex.getMessage());
		}
	}
	
	public boolean authenticateUser(String userName, String password) throws Exception {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query query = session.getNamedQuery("User.byUserNameAndPassword");
			query.setParameter("userName", userName);
			query.setParameter("password", password);
		
			List<User> userList = (List<User>) query.list();

			if(userList.size() >= 1) {
				return true;
			}
			
			return false;
		}
		catch(Exception ex) {
			// Rollback
			session.getTransaction().rollback();
	
			throw new Exception("Error encountered while attempting to authenticate user.\n" + ex.getMessage());
		}
		finally {
			// C	lose the session
			session.close();
		}
	}
}
