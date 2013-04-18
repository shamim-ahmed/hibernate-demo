package edu.buet.cse.hibernate.ch11.v1.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.buet.cse.hibernate.ch11.v1.interceptor.BookingInterceptor;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
  private static final Session session;
  
  static {
    try {
      Configuration config = new Configuration();
      config.setInterceptor(new BookingInterceptor());
      sessionFactory = config.configure().buildSessionFactory();
      session = sessionFactory.openSession();
    } catch (HibernateException ex) {
      ex.printStackTrace(System.err);
      throw new ExceptionInInitializerError(ex);
    }
  }
  
  public static Session getSession() {
    return session;
  }
  
  public static void cleanUp() {
    session.close();
    sessionFactory.close();
  }
  
  private HibernateUtil() {
  }
}
