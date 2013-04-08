package edu.buet.cse.billboard.v2.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard.v2.model.User;
import edu.buet.cse.billboard.v2.util.HibernateUtil;

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
  
  private UserDao() {
  }
}
