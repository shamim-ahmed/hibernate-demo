package edu.buet.cse.hibernate.ch06.v1.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
  private static final Session session;
  
  static {
	try {
	  sessionFactory = new Configuration().configure().buildSessionFactory();
	  session = sessionFactory.openSession();
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	  throw new ExceptionInInitializerError(ex);
	}
  }
  
  public synchronized static Session getSession() {
	return session;
  }
  
  public synchronized static void cleanUp() {
	session.close();
	sessionFactory.close();
  }

  private HibernateUtil() {
  }
}
