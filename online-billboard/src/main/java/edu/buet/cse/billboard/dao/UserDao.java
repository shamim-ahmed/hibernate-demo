package edu.buet.cse.billboard.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard.model.User;
import edu.buet.cse.billboard.util.HibernateUtil;

public class UserDao {
  public static User getUser(Long id) {
	if (id == null) {
	  return null;
	}
	
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	User user = (User) session.get(User.class, id);
	tx.commit();
	
	return user;
  }
  
  public static boolean saveUser(User user) {
	if (user == null) {
	  return false;
	}
	
	boolean result = false;
	Transaction tx = null;
	
	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  session.save(user);
	  tx.commit();
	  result = true;
	} catch (HibernateException ex) {
	  tx.rollback();
	} 
	
	return result;
  }
  
  public boolean deleteUser(User user) {
	if (user == null) {
	  return false;
	}
	
	boolean result = false;
	Transaction tx = null;
	
	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  session.delete(user);
	  tx.commit();
	  result = true;
	} catch (HibernateException ex) {
	  tx.rollback();
	} 
	
	return result;
  }
  
  private UserDao() {
  }
}
