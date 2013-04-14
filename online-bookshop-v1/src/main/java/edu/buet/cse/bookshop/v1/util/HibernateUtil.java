package edu.buet.cse.bookshop.v1.util;

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
