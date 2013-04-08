package edu.buet.cse.billboard.v1.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
  private static final ThreadLocal<Session> sessionContainer = new ThreadLocal<>();
  
  static {
	try {
	  sessionFactory = new Configuration().configure().buildSessionFactory();
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	  throw new ExceptionInInitializerError(ex);
	}
  }
  
  public synchronized static Session getSession() {
	Session session = sessionContainer.get();
	
	if (session == null) {
	  session = sessionFactory.openSession();
	  sessionContainer.set(session);
	}
	
	return session;
  }
  
  public synchronized static void cleanUp() {
	Session session = sessionContainer.get();
	
	if (session != null) {
	  session.close();
	}
	
	sessionFactory.close();
  }
  
  private HibernateUtil() {
  }
}
