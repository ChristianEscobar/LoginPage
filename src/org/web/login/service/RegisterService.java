package org.web.login.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.web.login.dto.User;

public class RegisterService {
	private SessionFactory sessionFactory = null;

	public RegisterService() throws Exception {
		try {
			this.sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch(Exception ex) {
			throw new Exception("Error encountered while attempting to initialize RegisterService.\n" + ex.getMessage());
		}
	}
	
	public boolean registerNewUser(String lastName, String firstName, String userName, String password) throws Exception {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
		
			User user = new User();
		
			user.setLastName(lastName);
			user.setFirstName(firstName);
			user.setUserName(userName);
			user.setPassword(password);
		
			session.save(user);
		
			// Commit the Transaction
			session.getTransaction().commit();
			
			return true;
		}
		catch(Exception ex) {
			// Rollback
			session.getTransaction().rollback();
	
			throw new Exception("Error encountered while attempting to register new user.\n" + ex.getMessage());
		}
		finally {
			// C	lose the session
			session.close();
		}
	}
	
	public boolean userAlreadyExists(String lastName, String firstName) throws Exception {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query query = session.getNamedQuery("User.byName");
			query.setParameter("firstName", firstName);
			query.setParameter("lastName", lastName);
		
			List<User> userList = (List<User>) query.list();

			if(userList.size() >= 1) {
				return true;
			}
			
			return false;
		}
		catch(Exception ex) {
			throw new Exception("Error encountered while attempting to check if users exists.\n" + ex.getMessage());
		}
		finally {
			session.close();
		}
	}
	
	public boolean userNameAlreadyExists(String userName) throws Exception {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query query = session.getNamedQuery("User.byUserName");
			query.setParameter("userName", userName);
		
			List<User> userList = (List<User>) query.list();

			if(userList.size() >= 1) {
				return true;
			}
			
			return false;
		}
		catch(Exception ex) {
			throw new Exception("Error encountered while attempting to check if userName exists.\n" + ex.getMessage());
		}
		finally {
			session.close();
		}
	}
}
