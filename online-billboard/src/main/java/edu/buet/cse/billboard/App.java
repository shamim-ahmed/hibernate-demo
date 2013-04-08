package edu.buet.cse.billboard;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard.model.User;
import edu.buet.cse.billboard.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
	Session session = null;
	
	try {
	  session = HibernateUtil.getSession();
	  
	  Transaction tx = session.beginTransaction();
	  User user = (User) session.get(User.class, 1L);
	  tx.commit();
	  
	  System.out.println(user);
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	}
  }
}
